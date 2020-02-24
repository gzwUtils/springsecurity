//		var sty="a";
//		var stycol="b";

      var head=new Vue({
      el: '#header',
 
       methods: {
       	 changstyle: function (style,color) {
      // `this` 在方法里指当前 Vue 实例
      console.log(event)
       var newCss=document.getElementById("stylehref");
       var colorCss=document.getElementById("stylecolor");	
      
      

    
       if(style=="layout"){
       	 newCss.href="css/"+color+".css";
      
       }else if(style=="color"){
       	colorCss.href="css/index_"+color+".css";
       	
       	
       }else{
       	 newCss.href="css/"+style+".css";
       	 colorCss.href="css/index_"+color+".css";
       	 
       }
    
    		
     	 
  
    }
  
 
   
  },/*,
    computed:{
		styfun:function(){

    	return sty;
   	},
   		stycolfun:function(){

    	return stycol;
   	}
    }*/
    })  
