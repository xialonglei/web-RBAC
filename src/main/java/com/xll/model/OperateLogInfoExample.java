package com.xll.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperateLogInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperateLogInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFromIpIsNull() {
            addCriterion("from_ip is null");
            return (Criteria) this;
        }

        public Criteria andFromIpIsNotNull() {
            addCriterion("from_ip is not null");
            return (Criteria) this;
        }

        public Criteria andFromIpEqualTo(String value) {
            addCriterion("from_ip =", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpNotEqualTo(String value) {
            addCriterion("from_ip <>", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpGreaterThan(String value) {
            addCriterion("from_ip >", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpGreaterThanOrEqualTo(String value) {
            addCriterion("from_ip >=", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpLessThan(String value) {
            addCriterion("from_ip <", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpLessThanOrEqualTo(String value) {
            addCriterion("from_ip <=", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpLike(String value) {
            addCriterion("from_ip like", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpNotLike(String value) {
            addCriterion("from_ip not like", value, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpIn(List<String> values) {
            addCriterion("from_ip in", values, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpNotIn(List<String> values) {
            addCriterion("from_ip not in", values, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpBetween(String value1, String value2) {
            addCriterion("from_ip between", value1, value2, "fromIp");
            return (Criteria) this;
        }

        public Criteria andFromIpNotBetween(String value1, String value2) {
            addCriterion("from_ip not between", value1, value2, "fromIp");
            return (Criteria) this;
        }

        public Criteria andOperateFuncIsNull() {
            addCriterion("operate_func is null");
            return (Criteria) this;
        }

        public Criteria andOperateFuncIsNotNull() {
            addCriterion("operate_func is not null");
            return (Criteria) this;
        }

        public Criteria andOperateFuncEqualTo(String value) {
            addCriterion("operate_func =", value, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncNotEqualTo(String value) {
            addCriterion("operate_func <>", value, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncGreaterThan(String value) {
            addCriterion("operate_func >", value, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncGreaterThanOrEqualTo(String value) {
            addCriterion("operate_func >=", value, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncLessThan(String value) {
            addCriterion("operate_func <", value, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncLessThanOrEqualTo(String value) {
            addCriterion("operate_func <=", value, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncLike(String value) {
            addCriterion("operate_func like", value, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncNotLike(String value) {
            addCriterion("operate_func not like", value, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncIn(List<String> values) {
            addCriterion("operate_func in", values, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncNotIn(List<String> values) {
            addCriterion("operate_func not in", values, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncBetween(String value1, String value2) {
            addCriterion("operate_func between", value1, value2, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andOperateFuncNotBetween(String value1, String value2) {
            addCriterion("operate_func not between", value1, value2, "operateFunc");
            return (Criteria) this;
        }

        public Criteria andVisitMethodIsNull() {
            addCriterion("visit_method is null");
            return (Criteria) this;
        }

        public Criteria andVisitMethodIsNotNull() {
            addCriterion("visit_method is not null");
            return (Criteria) this;
        }

        public Criteria andVisitMethodEqualTo(String value) {
            addCriterion("visit_method =", value, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodNotEqualTo(String value) {
            addCriterion("visit_method <>", value, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodGreaterThan(String value) {
            addCriterion("visit_method >", value, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodGreaterThanOrEqualTo(String value) {
            addCriterion("visit_method >=", value, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodLessThan(String value) {
            addCriterion("visit_method <", value, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodLessThanOrEqualTo(String value) {
            addCriterion("visit_method <=", value, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodLike(String value) {
            addCriterion("visit_method like", value, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodNotLike(String value) {
            addCriterion("visit_method not like", value, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodIn(List<String> values) {
            addCriterion("visit_method in", values, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodNotIn(List<String> values) {
            addCriterion("visit_method not in", values, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodBetween(String value1, String value2) {
            addCriterion("visit_method between", value1, value2, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodNotBetween(String value1, String value2) {
            addCriterion("visit_method not between", value1, value2, "visitMethod");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoIsNull() {
            addCriterion("visit_method_error_info is null");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoIsNotNull() {
            addCriterion("visit_method_error_info is not null");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoEqualTo(String value) {
            addCriterion("visit_method_error_info =", value, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoNotEqualTo(String value) {
            addCriterion("visit_method_error_info <>", value, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoGreaterThan(String value) {
            addCriterion("visit_method_error_info >", value, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoGreaterThanOrEqualTo(String value) {
            addCriterion("visit_method_error_info >=", value, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoLessThan(String value) {
            addCriterion("visit_method_error_info <", value, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoLessThanOrEqualTo(String value) {
            addCriterion("visit_method_error_info <=", value, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoLike(String value) {
            addCriterion("visit_method_error_info like", value, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoNotLike(String value) {
            addCriterion("visit_method_error_info not like", value, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoIn(List<String> values) {
            addCriterion("visit_method_error_info in", values, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoNotIn(List<String> values) {
            addCriterion("visit_method_error_info not in", values, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoBetween(String value1, String value2) {
            addCriterion("visit_method_error_info between", value1, value2, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andVisitMethodErrorInfoNotBetween(String value1, String value2) {
            addCriterion("visit_method_error_info not between", value1, value2, "visitMethodErrorInfo");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeIsNull() {
            addCriterion("login_out_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeIsNotNull() {
            addCriterion("login_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeEqualTo(Date value) {
            addCriterion("login_out_time =", value, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeNotEqualTo(Date value) {
            addCriterion("login_out_time <>", value, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeGreaterThan(Date value) {
            addCriterion("login_out_time >", value, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_out_time >=", value, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeLessThan(Date value) {
            addCriterion("login_out_time <", value, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_out_time <=", value, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeIn(List<Date> values) {
            addCriterion("login_out_time in", values, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeNotIn(List<Date> values) {
            addCriterion("login_out_time not in", values, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeBetween(Date value1, Date value2) {
            addCriterion("login_out_time between", value1, value2, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andLoginOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_out_time not between", value1, value2, "loginOutTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeIsNull() {
            addCriterion("method_cost_time is null");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeIsNotNull() {
            addCriterion("method_cost_time is not null");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeEqualTo(String value) {
            addCriterion("method_cost_time =", value, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeNotEqualTo(String value) {
            addCriterion("method_cost_time <>", value, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeGreaterThan(String value) {
            addCriterion("method_cost_time >", value, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeGreaterThanOrEqualTo(String value) {
            addCriterion("method_cost_time >=", value, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeLessThan(String value) {
            addCriterion("method_cost_time <", value, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeLessThanOrEqualTo(String value) {
            addCriterion("method_cost_time <=", value, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeLike(String value) {
            addCriterion("method_cost_time like", value, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeNotLike(String value) {
            addCriterion("method_cost_time not like", value, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeIn(List<String> values) {
            addCriterion("method_cost_time in", values, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeNotIn(List<String> values) {
            addCriterion("method_cost_time not in", values, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeBetween(String value1, String value2) {
            addCriterion("method_cost_time between", value1, value2, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andMethodCostTimeNotBetween(String value1, String value2) {
            addCriterion("method_cost_time not between", value1, value2, "methodCostTime");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("log_type like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<String> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<String> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andUriIsNull() {
            addCriterion("uri is null");
            return (Criteria) this;
        }

        public Criteria andUriIsNotNull() {
            addCriterion("uri is not null");
            return (Criteria) this;
        }

        public Criteria andUriEqualTo(String value) {
            addCriterion("uri =", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotEqualTo(String value) {
            addCriterion("uri <>", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThan(String value) {
            addCriterion("uri >", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThanOrEqualTo(String value) {
            addCriterion("uri >=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThan(String value) {
            addCriterion("uri <", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThanOrEqualTo(String value) {
            addCriterion("uri <=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLike(String value) {
            addCriterion("uri like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotLike(String value) {
            addCriterion("uri not like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriIn(List<String> values) {
            addCriterion("uri in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotIn(List<String> values) {
            addCriterion("uri not in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriBetween(String value1, String value2) {
            addCriterion("uri between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotBetween(String value1, String value2) {
            addCriterion("uri not between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andMehodIsNull() {
            addCriterion("mehod is null");
            return (Criteria) this;
        }

        public Criteria andMehodIsNotNull() {
            addCriterion("mehod is not null");
            return (Criteria) this;
        }

        public Criteria andMehodEqualTo(String value) {
            addCriterion("mehod =", value, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodNotEqualTo(String value) {
            addCriterion("mehod <>", value, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodGreaterThan(String value) {
            addCriterion("mehod >", value, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodGreaterThanOrEqualTo(String value) {
            addCriterion("mehod >=", value, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodLessThan(String value) {
            addCriterion("mehod <", value, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodLessThanOrEqualTo(String value) {
            addCriterion("mehod <=", value, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodLike(String value) {
            addCriterion("mehod like", value, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodNotLike(String value) {
            addCriterion("mehod not like", value, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodIn(List<String> values) {
            addCriterion("mehod in", values, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodNotIn(List<String> values) {
            addCriterion("mehod not in", values, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodBetween(String value1, String value2) {
            addCriterion("mehod between", value1, value2, "mehod");
            return (Criteria) this;
        }

        public Criteria andMehodNotBetween(String value1, String value2) {
            addCriterion("mehod not between", value1, value2, "mehod");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}