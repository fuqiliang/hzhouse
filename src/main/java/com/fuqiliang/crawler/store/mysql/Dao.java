package com.fuqiliang.crawler.store.mysql;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.fuqiliang.crawler.collector.secondhandhouse.SecondHouse;
import com.fuqiliang.crawler.collector.transcation.SoldOutHouse;
import com.fuqiliang.crawler.collector.transcation.SoldOutHouseDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Dao {
    private static Logger logger = LoggerFactory.getLogger(Dao.class);

    //private static final String TABLE_SECOND_HOUSE = "secondHouse";
    private static final String INSERT_SECOND_HOUSE_SQL = "insert ignore into secondHouse(" +
            "uniqueId, recordId, postDate, division, houseCentificationId," +
            "proxy, houseName, square, price) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_SOLD_OUT_HOUSE_SQL = "insert ignore into soldOutHouse(" +
            "id, name, soldOutDate, totalPrice, unitPrice, expectedPrice," +
            "layout, floor, square, structure, direction, age, fixture, elevator," +
            "usageYear, hasElevator) values (?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";

    private static void close(AutoCloseable... closeableList) {
        for (AutoCloseable closeable : closeableList) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertSoldOutHouse(SoldOutHouse soldOutHouse) throws SQLException {
        DruidPooledConnection con = null;
        PreparedStatement ps = null;
        try {
            con = DbPoolConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_SOLD_OUT_HOUSE_SQL);

            con.setAutoCommit(true);

            preparedStatement.setObject(1, soldOutHouse.getId());
            preparedStatement.setObject(2, soldOutHouse.getName());
            preparedStatement.setObject(3, soldOutHouse.getSoldOutDate());
            preparedStatement.setObject(4, soldOutHouse.getTotalPrice());
            preparedStatement.setObject(5, soldOutHouse.getUnitPrice());
            preparedStatement.setObject(6, soldOutHouse.getExpectedPrice());

            SoldOutHouseDetail detail = soldOutHouse.getDetail();
            preparedStatement.setObject(7, detail.getLayout());
            preparedStatement.setObject(8, detail.getFloor());
            preparedStatement.setObject(9, detail.getSquare());
            preparedStatement.setObject(10, detail.getStructure());
            preparedStatement.setObject(11, detail.getDirection());
            preparedStatement.setObject(12, detail.getAge());
            preparedStatement.setObject(13, detail.getFixture());
            preparedStatement.setObject(14, detail.getElevator());
            preparedStatement.setObject(15, detail.getUsageYear());
            preparedStatement.setObject(16, detail.getHasElevator());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("insertScondHouses secondhouse list failed", e);
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            close(ps, con);
        }
    }

    public static void insertScondHouses(List<SecondHouse> secondHouseList) throws SQLException {
        DruidPooledConnection con = null;
        PreparedStatement ps = null;
        try {
            con = DbPoolConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_SECOND_HOUSE_SQL);
            for (SecondHouse house: secondHouseList) {
                preparedStatement.setObject(1, house.getUniqueId());
                preparedStatement.setObject(2, house.getRecordId());
                preparedStatement.setObject(3, house.getPostDate());
                preparedStatement.setObject(4, house.getDivision());
                preparedStatement.setObject(5, house.getHouseCentificationId());
                preparedStatement.setObject(6, house.getProxy());
                preparedStatement.setObject(7, house.getHouseName());
                preparedStatement.setObject(8, house.getSquare());
                preparedStatement.setObject(9, house.getPrice());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            con.commit();
        } catch (SQLException e) {
           logger.error("insertScondHouses secondhouse list failed", e);
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            close(ps, con);
        }
    }
}
