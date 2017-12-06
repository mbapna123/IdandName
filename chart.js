Highcharts.chart('container', {
    chart: {
        type: 'scatter',
        zoomType: 'xy'
    },
    title: {
        text: 'Height vs Weight'
    },
    subtitle: {
        text: 'Spring JPA Project'
    },
    xAxis: {
        title: {
            enabled: true,
            text: 'Height (cm)'
        },
        startOnTick: true,
        endOnTick: true,
        showLastLabel: true
    },
    yAxis: {
        title: {
            text: 'Weight (kg)'
        }
    },
    legend: {
        layout: 'vertical',
        align: 'left',
        verticalAlign: 'top',
        x: 100,
        y: 70,
        floating: true,
        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
        borderWidth: 1
    },
    plotOptions: {
        scatter: {
            marker: {
                radius: 5,
                states: {
                    hover: {
                        enabled: true,
                        lineColor: 'rgb(100,100,100)'
                    }
                }
            },
            states: {
                hover: {
                    marker: {
                        enabled: false
                    }
                }
            },
            tooltip: {
                headerFormat: '<b>{series.name}</b><br>',
                pointFormat: '{point.x} cm, {point.y} kg'
            }
        }
    },
    series: [{
        name: 'Person',
        color: 'rgba(223, 83, 83, .5)',
        data: [${heightweight}]

    }, {
        name: 'Male',
        color: 'rgba(119, 152, 191, .5)',
        data: [[0,0]]
    }]
});

/**
 * 
 */