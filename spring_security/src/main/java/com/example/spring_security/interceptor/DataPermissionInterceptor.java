//package com.example.spring_security.interceptor;
//
//import antlr.collections.impl.IndexedVector;
//import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
//import com.baomidou.mybatisplus.extension.handlers.AbstractSqlParserHandler;
//import com.example.spring_security.annotation.DataPermission;
//import com.example.spring_security.domain.UserInfo;
//import lombok.extern.slf4j.Slf4j;
//import net.sf.jsqlparser.JSQLParserException;
//import net.sf.jsqlparser.parser.CCJSqlParserManager;
//import net.sf.jsqlparser.schema.Table;
//import net.sf.jsqlparser.statement.select.PlainSelect;
//import net.sf.jsqlparser.statement.select.Select;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.mapping.SqlCommandType;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.SystemMetaObject;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
//
//import java.io.StringReader;
//import java.sql.Connection;
//import java.util.Properties;
//
///**
// * @author 屈燃希
// * @version 1.0
// * @project
// */
//@Slf4j
//@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
//public class DataPermissionInterceptor extends AbstractSqlParserHandler implements Interceptor {
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
////        StatementHandler statementHandler = PluginUtils.realTarget(invocation.getTarget());
////        MetaObject metaObject = SystemMetaObject.forObject(statementHandler.getBoundSql());
////        sqlParser(metaObject);
////        MappedStatement mappedStatement =(MappedStatement) metaObject.getValue("delegate.mappedStatement");
////        BoundSql boundSql=(BoundSql) metaObject.getValue("delegate.boundSql");
////        if(SqlCommandType.SELECT == mappedStatement.getSqlCommandType()) {
////            DataPermission dataPermission =getDataPermission(mappedStatement);
////            if (shouldFilter(mappedStatement,dataPermission)){
////                String id=mappedStatement.getId();
////                log.info("\n 数据权限的过滤 Method-> {}",id);
////                String originSql=boundSql.getSql();
////                String dataPermissionSql =
////            }
////
////        }
//        return null;
//    }
//
//    private DataPermission getDataPermission(MappedStatement mappedStatement) {
//        String mappedStatementId =mappedStatement.getId();//获取mapper类名+方法名，前者是类名，后者是方法名
//        DataPermission dataPermission=null;
//        try {
//
//            String className= mappedStatementId.substring(0,mappedStatementId.lastIndexOf("."));
//            Class<?> clazz =Class.forName(className);//获取mapper类
//            if (clazz.isAnnotationPresent(DataPermission.class)){//判断mapper类是否有DataPermission类
//                dataPermission = clazz.getAnnotation(DataPermission.class);//获取该类上的注解
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return  dataPermission;
//
//    }
//    private  Boolean shouldFilter(MappedStatement mappedStatement,DataPermission dataPermission){
//        if (dataPermission !=null){
//            String methodName = StringUtils.substringAfterLast(mappedStatement.getId(),".");//获取mapper类的方法名
//            String methodPrefix =dataPermission.methodPrefix();//获取注解的属性methodPrefix
//            if (StringUtils.isNotBlank(methodPrefix) && StringUtils.startsWith(methodName,methodPrefix)){
//                return  Boolean.TRUE;
//            }
//            String[] methods =dataPermission.methods();//获取注解的上属性String[] methods
//            for (String method :methods){
//                if (StringUtils.equals(method,methodName)) {//判断该类的使用的方法名是否与注解上的声明一致。
//                    return Boolean.TRUE;
//                }
//            }
//        }
//        return  Boolean.FALSE;
//    }
//    private  String dataPermissionSql(String originSql,DataPermission dataPermission)
//    {
//        try {
//            if (StringUtils.isBlank(dataPermission.field())){
//                return  originSql;
//            }
//            Subject subject = SecurityUtils.getSubject();
//            UserInfo currentUser = (UserInfo) subject.getPrincipal();
//            if (currentUser ==null){//判断是否登录
//                return originSql;
//            }
//            CCJSqlParserManager parserManager = new CCJSqlParserManager();
//            Select select = (Select) parserManager.parse(new StringReader(originSql));
//            PlainSelect plainSelect =(PlainSelect) select.getSelectBody();
//            Table formItem = (Table) plainSelect.getFromItem();
//            String selectTableName =formItem.getAlias() == null ?formItem.getName() :formItem.getAlias().getName();
////            String dataPermissionSql = String.format("%s.%s in (%s)",selectTableName,dataPermission.field(),StringUtils.defaultString(currentUser));
//        } catch (JSQLParserException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    @Override
//    public Object plugin(Object target) {
//        return null;
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//}
