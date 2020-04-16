export default {
    setLogin: function(data){
        localStorage.setItem("auth",data);
            } ,
    getLogin: function(){
        return {
            auth:localStorage.getItem("auth")
        }
    },
    logout:function(){
         localStorage.removeItem("auth");
    }   
}