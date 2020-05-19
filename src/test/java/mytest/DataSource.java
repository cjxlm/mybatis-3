package mytest;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * DataSource
 *
 * @author caijinxun
 * @date 2020/3/4
 */
public class DataSource extends UnpooledDataSourceFactory {

    public DataSource(){
        this.dataSource = new DruidDataSource();
    }
}
