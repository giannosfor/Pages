package API;

import Beans.Article;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManagement implements Fields {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private Vector<Article> articles = new Vector<Article>();

    public DatabaseManagement() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(database, user, password);
            stmt = con.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vector<Article> getArticles() throws SQLException {
        ResultSet rs = stmt.executeQuery("select id,title,story from news ORDER BY id DESC LIMIT 10");      
        while (rs.next()) {
            articles.add(new Article( rs.getInt("id"), rs.getString("title"), rs.getString("story")) );
        }
        return articles;
    }

    public void addArticle(Article article) throws SQLException {

        String query = "INSERT INTO news (title,story) VALUES (?,?)";
        PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getStory().toString());
        boolean execute = preparedStatement.execute();
    }
    
    public void deleteArticle(Article article) throws SQLException {
        boolean rs = stmt.execute("DELETE FROM news WHERE id = " + article.getId());
    }
}
