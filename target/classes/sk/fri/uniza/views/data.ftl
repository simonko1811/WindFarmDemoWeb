<#-- @ftlvariable name="" type="sk.fri.uniza.views.DataView" -->
<div class="container">
    <br><br>
    <div class="row">
        <div class="col s12 m12">
            <div class="card">
                <div class="card-content">
                    <span class="card-title">Graf 2:</span>
                    <div class="row">
                        <div class="col s12">
                            <canvas id="myChart2"></canvas>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br><br>
</div>

<script defer>
    var ctx2 = document.getElementById('myChart2');
    var myChart = new Chart(ctx2, {
        type: 'line',
        data: {
            labels: ${labels},
            datasets: [{
                label: 'Board values',
                data: ${values},
                fill:false,
                backgroundColor: 'rgba(255, 99, 132, 1)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'Chart.js Line Chart'
            },
            tooltips: {
                mode: 'index',
                intersect: false,
            },
            hover: {
                mode: 'nearest',
                intersect: true
            },
            scales: {
                xAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: 'Time'
                    }
                }],
                yAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: 'Value'
                    }
                }]
            }
        }
    });
    function f() {
        console.log(myChart);
    }
    f();
</script>