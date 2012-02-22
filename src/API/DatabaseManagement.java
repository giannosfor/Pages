package API;

import Beans.Article;
import Beans.DatabaseBean;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManagement {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<Article> articles = new ArrayList<Article>();

    public DatabaseManagement(DatabaseBean dbbean) throws ClassNotFoundException, SQLException {
        Class.forName(DatabaseBean.getDriver());
        con = DriverManager.getConnection(dbbean.getDatabase(), dbbean.getUsername(), dbbean.getPassword());
        stmt = con.createStatement();
    }

    public ArrayList<Article> getArticles() {
        if (articles.isEmpty()) {
            try {
                ResultSet rsa = stmt.executeQuery("select id,title,story from news ORDER BY id DESC LIMIT 10");
                while (rsa.next()) {
                    articles.add(new Article(rsa.getInt("id"), rsa.getString("title"), rsa.getString("story")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        boolean rsb = stmt.execute("DELETE FROM news WHERE id = " + article.getId());
    }
}
