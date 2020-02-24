

var app = new Vue({
	el: '#mainapp',
	data: function() {
		return {
		  value1: null,
        value2: null,
          value3: null,
               value4: 4,
                value5: 3.7

		}
	},
	methods: {
     next() {
        if (this.active++ > 2) this.active = 0;
      }
	}
})