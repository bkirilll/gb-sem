package ru.ywojctb.seminarcrud.repositories;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ywojctb.seminarcrud.entities.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {


    private final JdbcTemplate jdbcTemplate;

    public User getUserById(Long id) {
        String sql = "SELECT * FROM userTable WHERE id = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userEntityRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getLong("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbcTemplate.query(sql, userEntityRowMapper);
    }

    public User saveUser(User user) {
        String sql = "INSERT INTO userTable (firstName, lastName) VALUES (? , ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteUserById(Long id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public void updateUser(User user) {
        String sql = "UPDATE usertable SET firstname = ?, lastname = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getId());

    }
}
