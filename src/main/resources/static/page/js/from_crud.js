

var app = new Vue({
	el: '#mainapp',
	data: function() {
		return {
		    form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: '',
        
        },
         num1: 1

		}
	},
	methods: {
  	onSubmit() {
        console.log('submit!');
     },
      handleChange(value) {
        console.log(value);
      }
	}
})