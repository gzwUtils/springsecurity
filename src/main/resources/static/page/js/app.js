var list = [{
	date: '',
	name: '王小虎',
	address: '上海市普陀区金沙江路 1518 弄'
}, {
	date: '',
	name: '王小虎',
	address: '上海市普陀区金沙江路 1517 弄'
}, {
	date: '2016-05-01',
	name: '王小虎',
	address: '上海市普陀区金沙江路 1519 弄'
}, {
	date: '2016-05-03',
	name: '王小虎',
	address: '上海市普陀区金沙江路 1516 弄'
}];
var list2 = [{
	date: '2016-05-02',
	name: '11',
	address: '上海市普陀区金沙江路 1518 弄'
}, {
	date: '2016-05-04',
	name: '111',
	address: '上海市普陀区金沙江路 1517 弄'
}, {
	date: '2016-05-01',
	name: '333',
	address: '上海市普陀区金沙江路 1519 弄'
}, {
	date: '2016-05-03',
	name: '王11',
	address: '上海市普陀区金沙江路 1516 弄'
}];
var listname = [{
	id: 'data'
}, {
	id: 'name'
}, {
	id: 'address'

}];
var cupage = 3;


var app = new Vue({
	el: '#mainapp',
	data: function() {
		return {
			tableData: list,
			name: "asd",
			currentPage: cupage,
			pagelist: [10, 50],
			pagesize: 100,
			total: 500,
			dialogFormVisible: false,
			form: {
				name: '',
				region: '',
				date1: '',
				date2: '',
				delivery: false,
				type: [],
				resource: '',
				desc: ''
			},
			datemsg:true,
			name:true,
			address:true,
			checkList: ['选中且禁用','复选框 A'],
			multipleSelection:[],
			formLabelWidth: '120px',
			obj:'',
			pickerOptions1: {
				disabledDate(time) {
					return time.getTime() > Date.now();
				},
				shortcuts: [{
					text: '今天',
					onClick(picker) {
						picker.$emit('pick', new Date());
					}
				}, {
					text: '昨天',
					onClick(picker) {
						const date = new Date();
						date.setTime(date.getTime() - 3600 * 1000 * 24);
						picker.$emit('pick', date);
					}
				}, {
					text: '一周前',
					onClick(picker) {
						const date = new Date();
						date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
						picker.$emit('pick', date);
					}
				}]
			},
			value2: '',

		}
	},
	methods: {
		changeStatus: function(event) {
			// `this` 在方法里指当前 Vue 实例
			this.$refs=event
		
			console.log(this.$refs)
		},
		  handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
     },
		changstyle: function(event) {
			// `this` 在方法里指当前 Vue 实例
			console.log(event)

		},
		greet: function(event) {
			// `this` 在方法里指当前 Vue 实例
			console.log(event)
			alert('Hello ' + this.name + '!')
			// `event` 是原生 DOM 事件
			this.tableData = list2
			if(event) {
				alert(event.target.tagName)
			}
		},
		chas: function(column, prop, order) {
			// `this` 在方法里指当前 Vue 实例
			console.log(column)
			console.log(prop)
			console.log(order)
		},
		handleSizeChange(val) {
			console.log(`每页 ${val} 条`);
		},
		handleCurrentChange(val) {
			console.log(`当前页: ${val}`);
		},
		onRowClick: function(event) {
			// `this` 在方法里指当前 Vue 实例
			console.log(event)
			this.obj=event
		},
		modify: function() {
			// `this` 在方法里指当前 Vue 实例
			this.dialogFormVisible=true;
			this.form.name=this.obj.name;
			console.log();
			
		},
		del: function() {
			// `this` 在方法里指当前 Vue 实例
			var list=this.multipleSelection;
			 this.$confirm('此操作将永久删除'+this.multipleSelection.length+'条信息, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
			console.log(this.multipleSelection);
		},
		 changeFun(val){
     		 this.multipleSelection = val;
     		 console.log(val);
 		  }

	}
})