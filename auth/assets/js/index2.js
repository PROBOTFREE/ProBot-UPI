
$(function () {
  "use strict";



  // chart 1

  var options = {
    series: [{
      name: "Net Sales",
      data: [4, 10, 25, 12, 25, 18, 40]
    }],
    chart: {
      width: 150,
      height: 55,
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
      width: 1.7,
      curve: 'smooth'
    },
    fill: {
      type: 'gradient',
      gradient: {
        shade: 'dark',
        gradientToColors: ['#0d6efd'],
        shadeIntensity: 1,
        type: 'vertical',
        opacityFrom: 0.8,
        opacityTo: 0.1,
        stops: [0, 100, 100, 100]
      },
    },

    colors: ["#0d6efd"],
    tooltip: {
      theme: "dark",
      fixed: {
        enabled: !1
      },
      x: {
        show: !1
      },
      y: {
        title: {
          formatter: function (e) {
            return ""
          }
        }
      },
      marker: {
        show: !1
      }
    },
    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
    }
  };

  var chart = new ApexCharts(document.querySelector("#chart1"), options);
  chart.render();




  // chart 2

  var options = {
    series: [{
      name: "Net Sales",
      data: [0, 8, 19, 12, 25, 5, 8]
    }],
    chart: {
      width: 150,
      height: 55,
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
      width: 1.7,
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
    tooltip: {
      theme: "dark",
      fixed: {
        enabled: !1
      },
      x: {
        show: !1
      },
      y: {
        title: {
          formatter: function (e) {
            return ""
          }
        }
      },
      marker: {
        show: !1
      }
    },
    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
    }
  };

  var chart = new ApexCharts(document.querySelector("#chart2"), options);
  chart.render();



  // chart 3

  var options = {
    series: [{
      name: "Net Sales",
      data: [2, 5, 40, 10, 15, 10, 10]
    }],
    chart: {
      width: 150,
      height: 55,
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
      width: 1.7,
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
    tooltip: {
      theme: "dark",
      fixed: {
        enabled: !1
      },
      x: {
        show: !1
      },
      y: {
        title: {
          formatter: function (e) {
            return ""
          }
        }
      },
      marker: {
        show: !1
      }
    },
    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
    }
  };

  var chart = new ApexCharts(document.querySelector("#chart3"), options);
  chart.render();



  // chart 4

  var options = {
    series: [{
      name: "Net Sales",
      data: [25, 10, 45, 12, 25, 18, 40]
    }],
    chart: {
      width: 150,
      height: 55,
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
      width: 1.7,
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
    tooltip: {
      theme: "dark",
      fixed: {
        enabled: !1
      },
      x: {
        show: !1
      },
      y: {
        title: {
          formatter: function (e) {
            return ""
          }
        }
      },
      marker: {
        show: !1
      }
    },
    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
    }
  };

  var chart = new ApexCharts(document.querySelector("#chart4"), options);
  chart.render();




  // chart 5

  var options = {
    series: [{
      name: "Net Sales",
      data: [2, 5, 60, 10, 30, 10, 25, 1]
    },
    {
      name: "Net Sales",
      data: [7, 10, 45, 15, 25, 15, 30, 10]
    }],
    chart: {
      //width:150,
      foreColor: "#9ba7b2",
      height: 280,
      type: 'line',
      toolbar: {
        show: !1,
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
      width: 3,
      curve: 'smooth'
    },
    fill: {
      type: 'gradient',
      gradient: {
        shade: 'dark',
        gradientToColors: ['#6f42c1', '#ff8f07'],
        shadeIntensity: 1,
        type: 'vertical',
        //opacityFrom: 0.8,
        //opacityTo: 0.1,
        stops: [0, 100, 100, 100]
      },
    },
    plotOptions: {
      bar: {
        horizontal: !1,
        columnWidth: "55%",
        endingShape: "rounded"
      }
    },
    colors: ["#6f42c1", '#ff8f07'],
    grid: {
      show: false,
      borderColor: 'rgba(0, 0, 0, 0.15)',
      strokeDashArray: 4,
    },
    tooltip: {
      theme: "dark",
      fixed: {
        enabled: !1
      },
      x: {
        show: !1
      },
      y: {
        title: {
          formatter: function (e) {
            return ""
          }
        }
      },
      marker: {
        show: !1
      }
    },
    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
    }
  };

  var chart = new ApexCharts(document.querySelector("#chart5"), options);
  chart.render();





  // chart 6

  var options = {
    series: [{
      name: "Net Sales",
      data: [20, 5, 60, 10, 30, 20, 25, 15, 31]
    },
    {
      name: "Net Sales",
      data: [17, 10, 45, 15, 25, 15, 40, 10, 24]
    }],
    chart: {
      //width:150,
      foreColor: "#9ba7b2",
      height: 265,
      type: 'bar',
      toolbar: {
        show: !1,
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
      width: 3,
      curve: 'smooth',
      colors: ['transparent']
    },
    fill: {
      type: 'gradient',
      gradient: {
        shade: 'dark',
        gradientToColors: ['#6f42c1', '#0d6efd'],
        shadeIntensity: 1,
        type: 'vertical',
        //opacityFrom: 0.8,
        //opacityTo: 0.1,
        stops: [0, 100, 100, 100]
      },
    },
    plotOptions: {
      bar: {
        horizontal: !1,
        columnWidth: "55%",
        endingShape: "rounded"
      }
    },
    colors: ["#6f42c1", '#0d6efd'],
    grid: {
      show: false,
      borderColor: 'rgba(0, 0, 0, 0.15)',
      strokeDashArray: 4,
    },
    tooltip: {
      theme: "dark",
      fixed: {
        enabled: !1
      },
      x: {
        show: !1
      },
      y: {
        title: {
          formatter: function (e) {
            return ""
          }
        }
      },
      marker: {
        show: !1
      }
    },
    xaxis: {
      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
    }
  };

  var chart = new ApexCharts(document.querySelector("#chart6"), options);
  chart.render();





});