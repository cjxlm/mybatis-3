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
package mytest.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//@Entity(Blog.class)
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     *
     * #{id}
     *
     * #{idd2d}  这里面随便
     */
    @Select("select * from blog where bid = #{idd2d} ")
     Blog selectBlogById(Integer bid);
//     不可行 ${param0}  ${arg0}
//    @Select("select * from blog where bid = ${param0} ")
//    Blog selectBlogByNo( Integer bid);

//    没对应上
//    @Select("select * from blog where bid = ${bid} ")
//    Blog selectBlogByNo( Integer bid);

    //对应 上可行
    @Select("select * from blog where bid = ${bid} ")
    Blog selectBlogByNo(@Param("bid") Integer bid);

}
