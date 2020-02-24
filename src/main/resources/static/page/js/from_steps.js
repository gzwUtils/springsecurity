

var app = new Vue({
	el: '#mainapp',
	data: function() {
		return {
		    active: 0

		}
	},
	methods: {
     next() {
        if (this.active++ > 2) this.active = 0;
      }
	}
})