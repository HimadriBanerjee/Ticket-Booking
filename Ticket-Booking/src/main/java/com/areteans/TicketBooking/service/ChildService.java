package com.areteans.TicketBooking.service;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class ChildService {
    private final JdbcTemplate jdbcTemplate;
    public Map<String, Object> saveC(Map<String, Object> child) {
        Map<String, Object> cMap = jdbcTemplate.queryForMap("insert into Child(idCard,guardian) values(?,?) RETURNING idCard",
                Long.parseLong((String) child.get("idCard")),
              // child.get("name"),
              // Integer.parseInt((String) child.get("age")),
              // child.get("address"),
              // Long.parseLong((String) child.get("contact")),
                child.get("guardian"));
        child.put("idCard", cMap.get("idCard"));
        return child;
    }
}
   /* public Child createChild(Child child) {
        Connection connection = PostgresManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into child(name, contact, address,guardian,idCard ) values (?,?,?,?,?)");
            preparedStatement.setString(1, child.getName());
            preparedStatement.setLong(2, child.getContact());
            preparedStatement.setString(3, child.getAddress());
            preparedStatement.setString(4, child.getGuardian());
            preparedStatement.setLong(5,child.getIdCard());
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement("select * from Passenger where name = ?");
            preparedStatement.setString(1, child.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Child(resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("address"),resultSet.getInt("idCard"),resultSet.getLong("contact"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Map<String, Object> createPassenger(Map<String, Object> passenger) {
        ChildService childService;
        return childService.createPassenger(passenger);
    }
}*/
