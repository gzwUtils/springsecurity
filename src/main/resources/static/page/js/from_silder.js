

var app = new Vue({
	el: '#mainapp',
	data: function() {
		return {
		    value1: 0,
        value2: 50,
        value3: 36,
        value4: 48,
        value5: 42,
          value6: 0,
        value7: 0,
         value8: 0,
           value9: [4, 8]
          
		}
	},
	methods: {
     formatTooltip(val) {
        return val / 100;
      }
	}
})