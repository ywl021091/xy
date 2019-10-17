 var getProvince = function getProvince(){
    var province = document.getElementById('province');
    var city = document.getElementById('city');
    //new Option("请选择城市","请选择城市"); 第一个参数是文本即显示的内容，第二个参数是值即传递的值
     for(i=0;i<provinces.length;i++){
         province.options[i+1] =new Option(provinces[i],provinces[i]);
     }
}
getProvince();
 var getCity = function getCity(provice){
     var city = document.getElementById('city');
    //selectedIndex 属性可设置或返回下拉列表中被选选项的索引号。
     var x = provice.selectedIndex;
             $("#city").empty();  
         if(x>0){
             var cityList = citys[x-1].split(",");
             for(i=0;i<cityList.length;i++){
                city.options[i] = new Option(cityList[i],cityList[i]);
            } 
        }else{
                 city.options[0] = new Option("","");
        }
} 