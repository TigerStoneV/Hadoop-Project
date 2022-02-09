/*!
* Start Bootstrap - Freelancer v7.0.5 (https://startbootstrap.com/theme/freelancer)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-freelancer/blob/master/LICENSE)
*/
//
// Scripts
// 
var ctx4 = document.getElementById('myChart4').getContext('2d'); 
var chart4 = new Chart(ctx4, {
    type: 'bar',
    data: {
    labels: ['2014','2015','2016','2017','2018','2019','2020'], 
    datasets: [{ 
        data: [200000 ,3000000, 4000000,500000,8000000,1000000,2000000],
        label: '주중', 
        backgroundColor: [
        'rgba(54, 162, 235, 0.2)',
        ],
        
        borderColor:[

            'rgba(54, 162, 235, 0.2)',
        ] ,
        borderWidth: 1,
         },
         { 
            data: [200000 ,3000000, 4000000,500000,8000000,1000000,2000000],
            label: '주말', 
            backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            ],
            borderColor:[
                'rgba(255, 99, 132, 0.2)',
 
            ] ,
            borderWidth: 1,
             }
    ] 
      },
      options: {
        responsive: false,
    }
});

var ctx3 = document.getElementById('myChart3');
var chart3 = new Chart(ctx3 , {
    type : 'line',
    data : {
        labels: ['일','월','화','수','목','금','토'],
        datasets: [{ 
            data: [0,2,4,6,8,10,20],
            label: "2014",
            borderColor: "red",
            fill: false
          }, { 
            data: [0,11,2,8,8,8,5],
            label: "2015",
            borderColor: "orange",
            fill: false
          }, { 
            data: [10,12,4,10,8,3,2],
            label: "2016",
            borderColor: "yellow",
            fill: false
          }, { 
            data: [0,12,1,2,8,10,12],
            label: "2017",
            borderColor: "green",
            fill: false
          }, { 
            data: [8,2,4,3,8,5,6],
            label: "2018",
            borderColor: "blue",
            fill: false
          },{ 
            data: [4,8,0,6,1,10,0],
            label: "2019",
            borderColor: "indigo",
            fill: false
          },{ 
            data: [11,2,2,6,8,10,1],
            label: "2020",
            borderColor: "purple",
            fill: false
          },{ 
            data: [9,3,6,7,2,1,7],
            label: "2020",
            borderColor: "black",
            fill: false
          }
        ]
      },
    options:{
        responsive: false
    }
})

var ctx2 = document.getElementById('myChart2');
var chart2 = new Chart(ctx2 , {
    type: 'bar',
    data: {
    labels: ['2014','2015','2016','2017','2018','2019','2020'], 
    datasets: [{ 
        data: [200000 ,3000000, 4000000,500000,8000000,1000000,2000000],
        label: '1분기',
        backgroundColor: [
            'red',
        ],
        borderColor:[
            'red',
        ] ,
        borderWidth: 1,
         },
         { 
            data: [200000 ,3000000, 4000000,500000,8000000,1000000,2000000],
            label: '2분기',  
            backgroundColor: [
               'orange'
            ],
            
            borderColor:[
                'orange',
            ] ,
            borderWidth: 1,
             },
             { 
                data: [200000 ,3000000, 4000000,500000,8000000,1000000,2000000],
                label: '3분기',
                backgroundColor: [
                    'yellow'
                ],
                
                borderColor:[
                  'yellow'
                ] ,
                borderWidth: 1,
                 },
                 { 
                    data: [200000 ,3000000, 4000000,500000,8000000,1000000,2000000],
                    label: '4분기',
                    backgroundColor: [
                        'green'
                    ],
                    
                    borderColor:[
                        'green'
                    ] ,
                    borderWidth: 1,
                }
    ] 
      },
      options: {
        responsive: false,
        scales: {
            x: {
              stacked: true,
            },
            y: {
              stacked: true
            }
          },
        plugins: {
            title: {
                display: true,
                fontSize: 500,
                text: '연도별 매출 금액'                
            }
        }
    }
});
    

var ctx1 = document.getElementById('myChart1').getContext('2d'); 
var chart = new Chart(ctx1, {
    type: 'bar',    
    data: {
    labels: ['2014','2015','2016','2017','2018','2019','2020'], 
    datasets: [{ 
        data: [200000 ,3000000, 4000000,500000,8000000,1000000,2000000],
        backgroundColor: [
            'red','orange','yellow','green','blue','indigo','purple'
        ],
        
        borderColor:[
            'red','orange','yellow','green','blue','indigo','purple'
        ] ,
        borderWidth: 1,
         }
    ] 
      },
      options: {
        responsive: false,
        plugins: {
            title: {
                display: true,
                fontSize: 500,
                text: '연도별 매출 금액'                
            }
        }
    }
});

 
window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 72,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});
