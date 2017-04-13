package com.util;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 2017/4/1.
 */
public class DBUtil {

    private static String className = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/spider?"
            + "useUnicode=true&characterEncoding=utf-8&useSSL=true";
    private static String user = "root";
    private static String password = "root";
    private static QueryRunner queryRunner = new QueryRunner();

    public static final String INSERT_PPRICE = "insert into jd_price(good_id,price,cur_time)values(?,?,?)";
    public static final String DELETE_PRICE = "DELETE FROM jd_price";

    public static final String SELECT_GOODS = "select * from jd_goods";

    public static String[]goodIds;

    //拒绝创建一个实例
    private DBUtil(){};

    static {
        //调用该类是即注册驱动、
        try{
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    //查询
    public static List<String> executeQuerySql(String sql) {
        List<String> result = new ArrayList<String>();
        try {
            List<Object[]> requestList = queryRunner.query(getConnection(), sql,
                   new ArrayListHandler(new BasicRowProcessor(){
                       @Override
                       public <T> List<T> toBeanList(ResultSet rs, Class<T> type) throws SQLException {
                           return super.toBeanList(rs, type);
                       }
                   }));
            for (Object[] objects : requestList) {
                result.add(objects[0].toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //获取连接
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    //执行一些更新或新增的sql语句或者删除
    public static void update(String sql, Object... params) {
        try {
            Connection conection = getConnection();
            queryRunner.update(conection, sql, params);
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 清空表
     * @param
     */
    public synchronized static void deletePriceTable() {
        String sql = "DELETE FROM jd_price";

        java.sql.PreparedStatement preparedStatement = null;
        try {
            Connection conn = getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            System.out.println("jd_price删除表成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * select操作
     * @param sql
     * @return
     */
    public static List<String> selectSQL(String sql ){
        List<String>goodIds = new ArrayList<String>();
        ResultSet resultSet = null;
        try {
            Connection conection = getConnection();
            PreparedStatement statement = conection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String goodid = resultSet.getString(2);
                goodIds.add(goodid);
                System.out.println("goodId =" + goodid);

            }

            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodIds;
    }



}
