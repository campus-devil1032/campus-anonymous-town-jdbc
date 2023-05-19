package com.campusjdbc.service;

import com.campusjdbc.dto.PostDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO {
    // todo Implement methods... ㅠㅠ
    private final DBConnector dbConnector = new DBConnector();

    @Override
    public PostDTO insertPost(PostDTO post) {
        String sql = "INSERT INTO posts (title, content, password) VALUES (?, ?, ?)";

        // 이 부분은 try-with-resource 라고 부릅니다. 한번 공부해보세요~
        try (
                Connection conn = dbConnector.getConnection();
                // PreparedStatement 는 SQL Injection 을 방어하는 가장 기본적인 기법이다. 공부하세요!
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getPassword());
            pstmt.executeUpdate();
            // Get the generated key (id)
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    post.setId(id);
                } else {
                    throw new SQLException("게시물 작성에 실패했습니다. 게시물의 ID를 받지 못했습니다.");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return post;
    }

    @Override
    public PostDTO selectPost(int id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        try (Connection conn = dbConnector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                PostDTO post = new PostDTO();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setPassword(rs.getString("password")); // 실제로 비밀번호는 안전한 방법으로 처리해야 합니다. 이 코드는 단순한 예시일 뿐입니다.
                return post;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PostDTO> selectAllPosts() {
        List<PostDTO> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts";
        try (Connection conn = dbConnector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                PostDTO post = new PostDTO();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public List<PostDTO> selectPostsPages(int pageSize, int page) {
        List<PostDTO> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts ORDER BY id LIMIT ? OFFSET ?";
        try (Connection conn = dbConnector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, pageSize);
            pstmt.setInt(2, (page - 1) * pageSize);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                PostDTO post = new PostDTO();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public int getSizeTable() {
        String sql = "SELECT COUNT(id) FROM posts";
        try (Connection conn = dbConnector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();) {
            if (rs.next())
                return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updatePost(PostDTO post) {
        String sql = "UPDATE posts SET title = ?, content = ? WHERE id = ? AND password = ?";
        try (Connection conn = dbConnector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setInt(3, post.getId());
            pstmt.setString(4, post.getPassword());
            int updatedRows = pstmt.executeUpdate();
            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePost(int id, String password) {
        String sql = "DELETE FROM posts WHERE id = ? AND password = ?";
        try (Connection conn = dbConnector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            int deletedRows = pstmt.executeUpdate();
            return deletedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}