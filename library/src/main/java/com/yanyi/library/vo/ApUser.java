package com.yanyi.library.vo;

/**
 * {
 * "id": 1,
 * "jsonrpc": "2.0",
 * "username": "Administrator",
 * "method": "user.login",
 * "params": {
 * "username": "Administrator",
 * "password": "21232f297a57a5a743894a0e4a801fc3"
 * }
 * }
 */
public class ApUser {
    private int id;
    private String jsonrpc;
    private String username;
    private String method;
    private Param params;

    public static class Param {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "Param{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Param getParams() {
        return params;
    }

    public void setParams(Param params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ApUser{" +
                "id=" + id +
                ", jsonrpc='" + jsonrpc + '\'' +
                ", username='" + username + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                '}';
    }
}
