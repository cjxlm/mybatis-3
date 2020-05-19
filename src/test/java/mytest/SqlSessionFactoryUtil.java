/**
 *    Copyright 2009-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package mytest;

import mytest.mapper.Blog;
import mytest.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * SqlSessionFactoryUtil
 *
 * @author caijinxun
 * @date 2020/3/4
 */
public class SqlSessionFactoryUtil {
    //首先创建静态成员变量sqlSessionFactory，静态变量被所有的对象所共享。
    public static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionManager sqlSessionManager=null;


    @Test
    public void sqlSessionFactoryTest(){
                String resource = "mybatis-config.xml";

        try {

            InputStream inputStream = Resources.getResourceAsStream(resource);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            BlogMapper blogMapper = sqlSessionFactory.openSession().getMapper(BlogMapper.class);

            //静态
//                        Blog blog = blogMapper.selectBlogById(2);
            //動態
            Blog blog = blogMapper.selectBlogByNo(2);
            System.out.println(blog);
        }catch (Exception e){

        }
    }

    @Test
    public void SqlSessionManagerTest(){
        final String resource = "mybatis-config.xml";
        final Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionManager = SqlSessionManager.newInstance(reader);
            BlogMapper blogMapper = sqlSessionManager.getMapper(BlogMapper.class);
            Blog blog = blogMapper.selectBlogById(1);
            System.out.println(blog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        SqlSession sqlSession = SqlSessionFactoryUtil.sqlSessionFactory.openSession();
//        sqlSession.selectList();




    }
}
