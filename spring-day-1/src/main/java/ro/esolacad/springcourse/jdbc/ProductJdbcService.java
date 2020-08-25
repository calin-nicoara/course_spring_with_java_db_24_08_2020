package ro.esolacad.springcourse.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProductJdbcService {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductJdbcService(final JdbcTemplate jdbcTemplate,
                              final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Integer countProducts() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM product",
                Integer.class);
    }

    public List<ProductJdbc> findAllProducts() {
        return jdbcTemplate.query("SELECT id, name, price FROM product",
                (resultSet, rowNumber) -> mapResultSetToProductJdbc(resultSet));
    }

    public ProductJdbc findProductById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id, name, price" +
                " FROM product where id = " + id,
                (resultSet, rowNumber) -> mapResultSetToProductJdbc(resultSet));
    }

    public void insertProduct(ProductJdbc productJdbc) {
        jdbcTemplate.update("INSERT INTO product(id, name, price)" +
                        " VALUES (?, ?, ?)",
                productJdbc.getId(),
                productJdbc.getName(),
                productJdbc.getPrice()
        );
    }

    private ProductJdbc mapResultSetToProductJdbc(final ResultSet resultSet) throws SQLException {
        ProductJdbc productJdbc = new ProductJdbc();

        productJdbc.setId(resultSet.getLong("id"));
        productJdbc.setName(resultSet.getString("name"));
        productJdbc.setPrice(resultSet.getBigDecimal("price"));

        return productJdbc;
    }

    public void insertProductWithNamed(ProductJdbc productJdbc) {
//        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
//                .addValue("id", productJdbc.getId())
//                .addValue("name", productJdbc.getName())
//                .addValue("price", productJdbc.getPrice());

        namedParameterJdbcTemplate.update("INSERT INTO product(id, name, price)" +
                " VALUES (:id, :name, :price)", new BeanPropertySqlParameterSource(productJdbc));
    }
}
