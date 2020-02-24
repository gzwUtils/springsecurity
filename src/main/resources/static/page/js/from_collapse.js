

var app = new Vue({
	el: '#mainapp',
	data: function() {
		return {
		     activeNames: ['1']

		}
	},
	methods: {
    handleChange(val) {
        console.log(val);
      }
	}
})