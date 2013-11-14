sap.ui.jsview("testingcharts.home", {

    /** Specifies the Controller belonging to this View. 
    * In the case that it is not implemented, or that "null" is returned, this View does not have a Controller.
    * @memberOf testingcharts.home
    */ 
    getControllerName : function() {
        return "testingcharts.home";
    },

    /** Is initially called once after the Controller has been instantiated. It is the place where the UI is constructed. 
    * Since the Controller is given to this method, its event handlers can be attached right away. 
    * @memberOf testingcharts.home
    */ 
    createContent : function(oController) {
        var model = new sap.ui.model.json.JSONModel({
            data: [
                {algorithm: 'Insertion Sort', time: 10, type: 'best'},
                {algorithm: 'Insertion Sort', time: 30, type: 'medium'},
                {algorithm: 'Insertion Sort', time: 100, type: 'worst'},
                {algorithm: 'Bubble Sort', time: 20, type: 'best'},
                {algorithm: 'Bubble Sort', time: 80, type: 'medium'},
                {algorithm: 'Bubble Sort', time: 110, type: 'worst'}
            ]
        });

        var ds = new sap.viz.ui5.data.FlattenedDataset({
            dimensions: [
                {
                    axis: 1,
                    name: 'Type',
                    value: '{type}'
                },
                {
                    axis: 2,
                    name: 'Algorithm',
                    value: '{algorithm}'
                }
            ],
            measures: [
                {
                    name: 'Time (ms)',
                    value: '{time}'
                }
            ],
            data: {
                path: '/data'
            }
        });

        var chart = sap.viz.ui5.Line('lineGraph', {
            height: '600px',
            width: '100%',
            title: {
                visible: true,
                text: 'Sort Algorithm Comparison'
            },
            dataset: ds,
            yAxis: new sap.viz.ui5.types.Axis({
                title: new sap.viz.ui5.types.Axis_title({
                    text: 'ms',
                    visible: true
                })
            })

        });

        chart.setModel(model);

        return chart;
    }

});
