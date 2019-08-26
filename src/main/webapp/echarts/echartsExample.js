function requireCallback (ec) {
    var myChart;
    var domMain = document.getElementById('echarts-main');
    echarts = ec;
    if (myChart && myChart.dispose) {
        myChart.dispose();
    }
    myChart = echarts.init(domMain);
    window.onresize = myChart.resize;
    myChart.setOption(option, true);
    window.onresize = myChart.resize;
}
 
var option = {
    title : {
        text: '信任关系',
        subtext: '虚构数据',
        x:'right',
        y:'bottom'
    },
    tooltip : {
        trigger: 'item',
        formatter: '{a} : {b}'
    },
    toolbox: {
        show : true,
        feature : {
            restore : {show: true},
            magicType: {show: true, type: ['force', 'chord']},
            saveAsImage : {show: true}
        }
    },
    legend: {
        x: 'left',
        data:['家人','朋友']
    },
    series : [
        {
            type:'force',
            name : "信任关系",
            ribbonType: false,
            categories : [
                {
                    name: '人物'
                },
                {
                    name: '家人'
                },
                {
                    name:'朋友'
                }
            ],
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        textStyle: {
                            color: '#333'
                        }
                    },
                    nodeStyle : {
                        brushType : 'both',
                        borderColor : 'rgba(255,215,0,0.4)',
                        borderWidth : 1
                    },
                    linkStyle: {
                        type: 'curve'
                    }
                },
                emphasis: {
                    label: {
                        show: false
                        // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
                    },
                    nodeStyle : {
                        //r: 30
                    },
                    linkStyle : {}
                }
            },
            useWorker: false,
            minRadius : 15,
            maxRadius : 25,
            gravity: 1.1,
            scaling: 1.1,
            roam: 'move',
            nodes:[
                {category:0, name: '张三', value : 10, label: '张三\n（主要）'},
                {category:1, name: '李四',value : 2},
                {category:1, name: '保罗',value : 3},
                {category:1, name: '克拉',value : 3},
                {category:1, name: '玛丽',value : 7},
                {category:2, name: '史密斯',value : 5},
                {category:2, name: '阿莱',value : 8},
                {category:2, name: '比利',value : 9},
                {category:2, name: '乔',value : 4},
                {category:2, name: '莱拉',value : 4},
                {category:2, name: '龙',value : 1},
            ],
            links : [
                {source : '李四', target : '张三', weight : 1, name: '女儿'},
                {source : '保罗', target : '张三', weight : 2, name: '父亲'},
                {source : '克拉', target : '张三', weight : 1, name: '母亲'},
                {source : '玛丽', target : '张三', weight : 2},
                {source : '史密斯', target : '张三', weight : 3, name: '合伙人'},
                {source : '阿莱', target : '张三', weight : 1},
                {source : '比利', target : '张三', weight : 6, name: '竞争对手'},
                {source : '乔', target : '张三', weight : 1, name: '爱将'},
                {source : '莱拉', target : '张三', weight : 1},
                {source : '龙', target : '张三', weight : 1},
                {source : '克拉', target : '保罗', weight : 1},
                {source : '阿莱', target : '保罗', weight : 1},
                {source : '阿莱', target : '克拉', weight : 1},
                {source : '阿莱', target : '玛丽', weight : 1},
                {source : '阿莱', target : '史密斯', weight : 1},
                {source : '比利', target : '阿莱', weight : 6},
                {source : '比利', target : '克拉', weight : 1},
                {source : '莱拉', target : '阿莱', weight : 1}
            ]
        }
    ]
};
 
var echarts;
 
require.config({
    paths: {
        echarts: './assets/echarts'
    }
});
launchExample();
 
var isExampleLaunched;
function launchExample() {
    if (isExampleLaunched) {
        return;
    }
 
    // 按需加载
    isExampleLaunched = 1;
    require(
        [
            'echarts',
            'echarts/chart/force',
            'echarts/chart/chord',
        ],
        requireCallback
    );
}