package com.mikola.a1task3.repository;

import com.mikola.a1task3.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PostingRepository extends JpaRepository<Posting, UUID> {

    String SELECT_BY_YEAR = """
            SELECT * FROM posting 
            WHERE EXTRACT(YEAR FROM pstng_date) = :my_year
            """;
    String SELECT_BY_MONTH = """
            SELECT * FROM posting 
            WHERE EXTRACT(YEAR FROM pstng_date) = :my_year 
                  AND EXTRACT(MONTH FROM pstng_date) = :my_month
            """;

    String SELECT_BY_QUARTER = """
            SELECT * FROM posting 
            WHERE EXTRACT(YEAR FROM pstng_date) = :my_year 
                  AND EXTRACT(QUARTER FROM pstng_date) = :my_quarter
            """;

    String SELECT_BY_DAY = """
            SELECT * FROM posting 
            WHERE EXTRACT(YEAR FROM pstng_date) = :my_year 
                  AND EXTRACT(MONTH FROM pstng_date) = :my_month 
                  AND EXTRACT(DAY FROM pstng_date) = :my_day
            """;

    String SELECT_BY_YEAR_AND_AUTHORIZED_POSTING = """
            SELECT * FROM posting 
            WHERE EXTRACT(YEAR FROM pstng_date) = :my_year
                  AND is_authorized_posting = true
            """;

    String SELECT_BY_MONTH_AND_AUTHORIZED_POSTING = """
            SELECT * FROM posting 
            WHERE EXTRACT(YEAR FROM pstng_date) = :my_year 
                  AND EXTRACT(MONTH FROM pstng_date) = :my_month
                  AND is_authorized_posting = true
            """;

    String SELECT_BY_QUARTER_AND_AUTHORIZED_POSTING = """
            SELECT * FROM posting 
            WHERE EXTRACT(YEAR FROM pstng_date) = :my_year 
                  AND EXTRACT(QUARTER FROM pstng_date) = :my_quarter
                  AND is_authorized_posting = true
            """;

    String SELECT_BY_DAY_AND_AUTHORIZED_POSTING = """
            SELECT * FROM posting 
            WHERE EXTRACT(YEAR FROM pstng_date) = :my_year 
                  AND EXTRACT(MONTH FROM pstng_date) = :my_month 
                  AND EXTRACT(DAY FROM pstng_date) = :my_day
                  AND is_authorized_posting = true
            """;

    @Query(value = SELECT_BY_YEAR, nativeQuery = true)
    List<Posting> getByYear(@Param("my_year") double my_year);

    @Query(value = SELECT_BY_QUARTER, nativeQuery = true)
    List<Posting> getByQuarter(@Param("my_year") double my_year,
                               @Param("my_quarter") int my_quarter);

    @Query(value = SELECT_BY_MONTH, nativeQuery = true)
    List<Posting> getByMonth(@Param("my_year") double my_year,
                             @Param("my_month") double my_month);

    @Query(value = SELECT_BY_DAY, nativeQuery = true)
    List<Posting> getByDay(@Param("my_year") double my_year,
                           @Param("my_month") double my_month,
                           @Param("my_day") double my_day);

    @Query(value = SELECT_BY_YEAR_AND_AUTHORIZED_POSTING, nativeQuery = true)
    List<Posting> getAuthorizedByYear(@Param("my_year") double my_year);

    @Query(value = SELECT_BY_QUARTER_AND_AUTHORIZED_POSTING, nativeQuery = true)
    List<Posting> getAuthorizedByQuarter(@Param("my_year") double my_year,
                               @Param("my_quarter") int my_quarter);

    @Query(value = SELECT_BY_MONTH_AND_AUTHORIZED_POSTING, nativeQuery = true)
    List<Posting> getAuthorizedByMonth(@Param("my_year") double my_year,
                             @Param("my_month") double my_month);

    @Query(value = SELECT_BY_DAY_AND_AUTHORIZED_POSTING, nativeQuery = true)
    List<Posting> getAuthorizedByDay(@Param("my_year") double my_year,
                           @Param("my_month") double my_month,
                           @Param("my_day") double my_day);
}
