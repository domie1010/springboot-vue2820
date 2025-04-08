const base = {
    get() {
        return {
            url : "http://localhost:8080/dianzishu/",
            name: "dianzishu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/dianzishu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "电子书管理"
        } 
    }
}
export default base
