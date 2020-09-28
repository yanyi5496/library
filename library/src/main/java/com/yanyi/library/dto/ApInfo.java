package com.yanyi.library.dto;

/**
 * {
 * "id": 1,
 * "jsonrpc": "2.0",
 * "result": {
 * "success": "true",
 * "sessionId": "81b66b3620359c2dcbcf23b42a7df9bf",
 * "apmac": "34:E7:0B:00:0B:C0",
 * "apmode": "CLOUD",
 * "csp_website": "haptocloud.han-networks.com",
 * "flag": 2,
 * "countryFlag": "CN",
 * "licenseControl": "",
 * "syncmsgs": "true"
 * },
 * "error": {
 * "errorCode": 0,
 * "errorMessage": ""
 * }
 * }
 */
public class ApInfo {
    private int id;
    private String jsonrpc;
    private Result result;
    private Error error;

    public static class Result {
        private String success;
        private String sessionId;
        private String apmac;
        private String apmode;
        private String csp_websote;
        private int id;
        private String countryFlag;
        private String licenseControl;
        private String syncmsgs;

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getApmac() {
            return apmac;
        }

        public void setApmac(String apmac) {
            this.apmac = apmac;
        }

        public String getApmode() {
            return apmode;
        }

        public void setApmode(String apmode) {
            this.apmode = apmode;
        }

        public String getCsp_websote() {
            return csp_websote;
        }

        public void setCsp_websote(String csp_websote) {
            this.csp_websote = csp_websote;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCountryFlag() {
            return countryFlag;
        }

        public void setCountryFlag(String countryFlag) {
            this.countryFlag = countryFlag;
        }

        public String getLicenseControl() {
            return licenseControl;
        }

        public void setLicenseControl(String licenseControl) {
            this.licenseControl = licenseControl;
        }

        public String getSyncmsgs() {
            return syncmsgs;
        }

        public void setSyncmsgs(String syncmsgs) {
            this.syncmsgs = syncmsgs;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "success='" + success + '\'' +
                    ", sessionId='" + sessionId + '\'' +
                    ", apmac='" + apmac + '\'' +
                    ", apmode='" + apmode + '\'' +
                    ", csp_websote='" + csp_websote + '\'' +
                    ", id=" + id +
                    ", countryFlag='" + countryFlag + '\'' +
                    ", licenseControl='" + licenseControl + '\'' +
                    ", syncmsgs='" + syncmsgs + '\'' +
                    '}';
        }
    }

    public static class Error {
        private int errorCode;
        private String errorMessage;
        private String errornum;
        private String totalnum;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrornum() {
            return errornum;
        }

        public void setErrornum(String errornum) {
            this.errornum = errornum;
        }

        public String getTotalnum() {
            return totalnum;
        }

        public void setTotalnum(String totalnum) {
            this.totalnum = totalnum;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "errorCode=" + errorCode +
                    ", errorMessage='" + errorMessage + '\'' +
                    ", errornum='" + errornum + '\'' +
                    ", totalnum='" + totalnum + '\'' +
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ApInfo{" +
                "id=" + id +
                ", jsonrpc='" + jsonrpc + '\'' +
                ", result=" + result +
                ", error=" + error +
                '}';
    }
}
