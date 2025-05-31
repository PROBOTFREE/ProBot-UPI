$(function() {
	"use strict";


     // chart 1

     var options = {
        series: [{
          name: "Desktops",
          data: [4, 41, 35, 51, 25, 8]
      }],
        chart: {
        width:150,
        height: 50,
        type: 'area',
        sparkline: {
            enabled: !0
        },
        zoom: {
          enabled: false
        }
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: 2,
        curve: 'smooth'
      },
      fill: {
        type: 'gradient',
        gradient: {
          shade: 'dark',
          gradientToColors: [ '#0d6efd'],
          shadeIntensity: 1,
          type: 'vertical',
          opacityFrom: 0.8,
          opacityTo: 0.1,
          stops: [0, 100, 100, 100]
        },
      },

      colors: ["#0d6efd"],
     
      xaxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
      }
      };

      var chart = new ApexCharts(document.querySelector("#chart1"), options);
      chart.render();





     // chart 2

     var options = {
        series: [{
          name: "Desktops",
          data: [10, 41, 30, 51, 25, 15]
      }],
        chart: {
        width:150,
        height: 50,
        type: 'bar',
        sparkline: {
            enabled: !0
        },
        zoom: {
          enabled: false
        }
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: 2,
        curve: 'smooth'
      },
      fill: {
        type: 'gradient',
        gradient: {
          shade: 'dark',
          gradientToColors: ['#fc185a'],
          shadeIntensity: 1,
          type: 'vertical',
          opacityFrom: 0.8,
          opacityTo: 0.1,
          stops: [0, 100, 100, 100]
        },
      },

      colors: ["#fc185a"],
     
      xaxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
      }
      };

      var chart = new ApexCharts(document.querySelector("#chart2"), options);
      chart.render();




     // chart 3

     var options = {
        series: [{
          name: "Desktops",
          data: [4, 41, 35, 51, 25, 8]
      }],
        chart: {
        width:150,
        height: 50,
        type: 'area',
        sparkline: {
            enabled: !0
        },
        zoom: {
          enabled: false
        }
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: 2,
        curve: 'smooth'
      },
      fill: {
        type: 'gradient',
        gradient: {
          shade: 'dark',
          gradientToColors: ['#02c27a'],
          shadeIntensity: 1,
          type: 'vertical',
          opacityFrom: 0.8,
          opacityTo: 0.1,
          stops: [0, 100, 100, 100]
        },
      },

      colors: ["#02c27a"],
     
      xaxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
      }
      };

      var chart = new ApexCharts(document.querySelector("#chart3"), options);
      chart.render();



     // chart 4

     var options = {
        series: [{
          name: "Desktops",
          data: [14, 41, 35, 51, 25, 18]
      }],
        chart: {
        width:150,
        height: 50,
        type: 'bar',
        sparkline: {
            enabled: !0
        },
        zoom: {
          enabled: false
        }
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: 2,
        curve: 'smooth'
      },
      fill: {
        type: 'gradient',
        gradient: {
          shade: 'dark',
          gradientToColors: ['#fd7e14'],
          shadeIntensity: 1,
          type: 'vertical',
          opacityFrom: 0.8,
          opacityTo: 0.1,
          stops: [0, 100, 100, 100]
        },
      },

      colors: ["#fd7e14"],
     
      xaxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
      }
      };

      var chart = new ApexCharts(document.querySelector("#chart4"), options);
      chart.render();



     // chart 5

     var options = {
        series: [{
          name: "Desktops",
          data: [14, 41, 35, 51, 25, 18, 21, 35, 15]
      }],
        chart: {
        foreColor: "#eee",
        height: 200,
        type: 'bar',
        toolbar: {
            show: !1
        },
        sparkline: {
            enabled: !1
        },
        zoom: {
          enabled: false
        }
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: 2,
        curve: 'smooth'
      },
      plotOptions: {
        bar: {
            columnWidth: "45%",
            endingShape: "rounded"
        }
    },
      fill: {
        type: 'gradient',
        gradient: {
          shade: 'dark',
          gradientToColors: ['#fff'],
          shadeIntensity: 1,
          type: 'vertical',
          opacityFrom: 0.8,
          opacityTo: 0.1,
          stops: [0, 100, 100, 100]
        },
      },
      colors: ["#fff"],
      grid: {
        show: true,
        borderColor: 'rgba(255, 255, 255, 0.15)',
      },
      xaxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
      }
      };

      var chart = new ApexCharts(document.querySelector("#chart5"), options);
      chart.render();




    // chart 6

    var options = {
      series: [44, 55, 41],
      chart: {
          height: 237,
          type: 'donut',
      },
      legend: {
          position: 'bottom',
          show: !1
      },
      colors: ["#fff", "rgba(255, 255, 255, 0.70)", "rgba(255, 255, 255, 0.20)"],
  dataLabels: {
    enabled: !1
  },
      plotOptions: {
    pie: {
      donut: {
        size: "80%"
      }
    }
  },
      responsive: [{
          breakpoint: 480,
          options: {
              chart: {
                  height: 200
              },
              legend: {
                  position: 'bottom',
                  show: !0
              }
          }
      }]
  };

  var chart = new ApexCharts(document.querySelector("#chart6"), options);
  chart.render();
  



     // chart 7

     var options = {
        series: [{
          name: "Desktops",
          data: [14, 41, 35, 51, 25, 40, 21, 35, 15]
      }],
        chart: {
        foreColor: "#eee",
        height: 200,
        type: 'area',
        toolbar: {
            show: !1
        },
        sparkline: {
            enabled: !1
        },
        zoom: {
          enabled: false
        }
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: 2,
        curve: 'smooth'
      },
      plotOptions: {
        bar: {
            columnWidth: "45%",
            endingShape: "rounded"
        }
    },
      fill: {
        type: 'gradient',
        gradient: {
          shade: 'dark',
          gradientToColors: ['#fff'],
          shadeIntensity: 1,
          type: 'vertical',
          opacityFrom: 0.8,
          opacityTo: 0.1,
          stops: [0, 100, 100, 100]
        },
      },
      colors: ["#fff"],
      grid: {
        show: true,
        borderColor: 'rgba(255, 255, 255, 0.15)',
      },
      xaxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
      }
      };

      var chart = new ApexCharts(document.querySelector("#chart7"), options);
      chart.render();



     // chart 8

     var options = {
      series: [{
        name: "Desktops",
        data: [20, 50, 25, 65, 22, 45]
    }],
      chart: {
     // width:150,
      height: 85,
      type: 'area',
      sparkline: {
          enabled: !0
      },
      zoom: {
        enabled: false
      }
    },
    dataLabels: {
      enabled: false
    },
    stroke: {
      width: 2,
      curve: 'smooth'
    },
    fill: {
      type: 'gradient',
      gradient: {
        shade: 'dark',
        gradientToColors: ['#6f42c1'],
        shadeIntensity: 1,
        type: 'vertical',
        opacityFrom: 0.8,
        opacityTo: 0.1,
        stops: [0, 100, 100, 100]
      },
    },

    colors: ["#6f42c1"],
   
    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
    }
    };

    var chart = new ApexCharts(document.querySelector("#chart8"), options);
    chart.render();





// chart 9

var options = {
  series: [{
    name: "Desktops",
    data: [24, 41, 35, 51, 25, 15]
}],
  chart: {
 // width:150,
  height: 85,
  type: 'area',
  sparkline: {
      enabled: !0
  },
  zoom: {
    enabled: false
  }
},
dataLabels: {
  enabled: false
},
stroke: {
  width: 2,
  curve: 'smooth'
},
fill: {
  type: 'gradient',
  gradient: {
    shade: 'dark',
    gradientToColors: ['#ffc107'],
    shadeIntensity: 1,
    type: 'vertical',
    opacityFrom: 0.8,
    opacityTo: 0.1,
    stops: [0, 100, 100, 100]
  },
},

colors: ["#ffc107"],

xaxis: {
  categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
}
};

var chart = new ApexCharts(document.querySelector("#chart9"), options);
chart.render();



// chart 10 

var options = {
  series: [75],
  chart: {
  height: 310,
  type: 'radialBar',
  toolbar: {
    show: false
  }
},
plotOptions: {
  radialBar: {
    startAngle: -135,
    endAngle: 225,
     hollow: {
      margin: 0,
      size: '80%',
      background: 'transparent',
      image: undefined,
      imageOffsetX: 0,
      imageOffsetY: 0,
      position: 'front',
      dropShadow: {
        enabled: false,
        top: 3,
        left: 0,
        blur: 4,
        opacity: 0.24
      }
    },
    track: {
      background: 'rgba(0, 0, 0, 0.1)',
      strokeWidth: '67%',
      margin: 0, // margin is in pixels
      dropShadow: {
        enabled: false,
        top: -3,
        left: 0,
        blur: 4,
        opacity: 0.35
      }
    },

    dataLabels: {
      show: true,
      name: {
        offsetY: -10,
        show: true,
        color: '#888',
        fontSize: '17px'
      },
      value: {
        formatter: function(val) {
          return parseInt(val);
        },
        color: '#111',
        fontSize: '36px',
        show: true,
      }
    }
  }
},
fill: {
  type: 'gradient',
  gradient: {
    shade: 'dark',
    type: 'horizontal',
    shadeIntensity: 0.5,
    gradientToColors: ['#fc185a'],
    inverseColors: true,
    opacityFrom: 1,
    opacityTo: 1,
    stops: [0, 100]
  }
},
colors: ["#fd7e14"],
stroke: {
  lineCap: 'round'
},
labels: ['Total Leads'],
};

var chart = new ApexCharts(document.querySelector("#chart10"), options);
chart.render();





   // chart 11

     var options = {
      series: [{
        name: "Desktops",
        data: [20, 41, 30, 51, 25, 60, 35, 54, 26, 18, 22, 43]
    }],
      chart: {
      //width:150,
      height: 210,
      type: 'bar',
      sparkline: {
          enabled: !0
      },
      zoom: {
        enabled: false
      }
    },
    dataLabels: {
      enabled: false
    },
    // stroke: {
    //   width: 2,
    //   curve: 'smooth'
    // },
    plotOptions: {
      bar: {
          columnWidth: "45%",
          endingShape: "rounded"
      }
  },
    fill: {
      type: 'gradient',
      gradient: {
        shade: 'dark',
        gradientToColors: ['#02c27a'],
        shadeIntensity: 1,
        type: 'vertical',
        //opacityFrom: 0.8,
        //opacityTo: 0.1,
        stops: [0, 100, 100, 100]
      },
    },

    colors: ["#02c27a"],
   
    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
    }
    };

    var chart = new ApexCharts(document.querySelector("#chart11"), options);
    chart.render();




// chart 12

var options = {
  series: [85],
  chart: {
  height: 300,
  type: 'radialBar',
  toolbar: {
    show: false
  }
},
plotOptions: {
  radialBar: {
    startAngle: -90,
    endAngle: 90,
     hollow: {
      margin: 0,
      size: '80%',
      background: 'transparent',
      image: undefined,
      imageOffsetX: 0,
      imageOffsetY: 0,
      position: 'front',
      dropShadow: {
        enabled: false,
        top: 3,
        left: 0,
        blur: 4,
        opacity: 0.24
      }
    },
    track: {
      background: 'rgba(0, 0, 0, 0.1)',
      strokeWidth: '67%',
      margin: 0, // margin is in pixels
      dropShadow: {
        enabled: false,
        top: -3,
        left: 0,
        blur: 4,
        opacity: 0.35
      }
    },

    dataLabels: {
      show: true,
      name: {
        offsetY: -10,
        show: true,
        color: '#888',
        fontSize: '17px'
      },
      value: {
        formatter: function(val) {
          return parseInt(val);
        },
        color: '#111',
        fontSize: '36px',
        show: true,
      }
    }
  }
},
fill: {
  type: 'gradient',
  gradient: {
    shade: 'dark',
    type: 'horizontal',
    shadeIntensity: 0.5,
    gradientToColors: ['#0866ff'],
    inverseColors: true,
    opacityFrom: 1,
    opacityTo: 1,
    stops: [0, 100]
  }
},
colors: ["#fc185a"],
stroke: {
  lineCap: 'round'
},
labels: ['Total Orders'],
};

var chart = new ApexCharts(document.querySelector("#chart12"), options);
chart.render();




// chart 13

var options = {
  series: [270, 55, 41, 35],
  chart: {
      height: 275,
      type: 'donut',
  },
  legend: {
      position: 'bottom',
      show: !1
  },
  colors: ["#0d6efd", "#fc185a", "#02c27a", "#fd7e14"],
dataLabels: {
enabled: !1
},
  plotOptions: {
pie: {
  donut: {
    size: "85%"
  }
}
},
  responsive: [{
      breakpoint: 480,
      options: {
          chart: {
              height: 270
          },
          legend: {
              position: 'bottom',
              show: !1
          }
      }
  }]
};

var chart = new ApexCharts(document.querySelector("#chart13"), options);
chart.render();






});