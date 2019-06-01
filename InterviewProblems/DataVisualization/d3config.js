/*
Author:         Tenzin Khando
Date:           2019-06-01
Description:    Setting up and configuring the layout of d3 graph
*/

let parse = d3.time.format("%Y-%m-%d").parse;

// Transpose the data into layers
let dataset = d3.layout.stack()( payTypesIds.map(function(payType) {
  return data.map(function(d) {
    // Shorten the name of the pay type
    let payTypeName = payTypesIdsMap[payType];
    payTypeName = ( payTypeName.length > 9 ? `${payTypeName.substring(0,10)}...` : payTypeName);
    return {x: parse(d.date), y: ((payType in d) ? +d[payType] : 0 ), label: payTypeName };
  });
}));

// Set x, y and colors
let x = d3.scale.ordinal()
  .domain(dataset[0].map(function(d) { return d.x; }))
  .rangeRoundBands([10, width-10], 0.02);

let y = d3.scale.linear()
  .domain([0, d3.max(dataset, function(d) {  return d3.max(d, function(d) { return d.y0 + d.y; });  })])
  .range([height, 0]);

// Define and draw axes
let yAxis = d3.svg.axis()
  .scale(y)
  .orient("left")
  .ticks(5)
  .tickSize(-width, 0, 0)
  .tickFormat( function(d) { return d } );

let xAxis = d3.svg.axis()
  .scale(x)
  .orient("bottom")
  .ticks(15)
  .tickFormat(d3.time.format("%m/%d"));

svg.append("g")
  .attr("class", "y axis")
  .call(yAxis);

svg.append("g")
  .attr("class", "x axis")
  .attr("transform", "translate(0," + height + ")")
  .call(xAxis);


// Create groups for each series, rects for each segment 
let groups = svg.selectAll("g.cost")
  .data(dataset)
  .enter().append("g")
  .attr("class", "cost")
  .style("fill", function(d, i) { return colors[i]; });

let rect = groups.selectAll("rect")
  .data(function(d) { return d; })
  .enter()
  .append("rect")
  .attr("x", function(d) { return x(d.x); })
  .attr("y", function(d) { return y(d.y0 + d.y); })
  .attr("height", function(d) { return y(d.y0) - y(d.y0 + d.y); })
  .attr("width", x.rangeBand())
  .on("mouseover", function() { tooltip.style("display", null); })
  .on("mouseout", function() { tooltip.style("display", "none"); })
  .on("mousemove", function(d) {
      console.log('moving mouse');
    let xPosition = d3.mouse(this)[0] - 15;
    let yPosition = d3.mouse(this)[1] - 25;
    tooltip.attr("transform", "translate(" + xPosition + "," + yPosition + ")");
    tooltip.select("text").html( `${d.label}<br>$${d.y}`);
    tooltip.selectAll("text").text(function(i, t) {
        return (t == 1) ? `$${d.y}` : d.label;
    });
  });


// Draw legend
let legend = svg.selectAll(".legend")
  .data(colors)
  .enter().append("g")
  .attr("class", "legend")
  .attr("transform", function(d, i) { return "translate(30," + i * 19 + ")"; });
 
legend.append("rect")
  .attr("x", width - 18)
  .attr("width", 18)
  .attr("height", 18)
  .style("fill", function(d, i) {return colors.slice()[i];});
 
legend.append("text")
  .attr("x", width + 5)
  .attr("y", 9)
  .attr("dy", ".35em")
  .style("text-anchor", "start")
  .text(function(d, i) { 
      return payTypesIdsMap[i+1];
  });


// Prep the tooltip bits, initial display is hidden
let tooltip = svg.append("g")
  .attr("class", "tooltip")
  .style("display", "none");
    
tooltip.append("rect")
  .attr("width", 100)
  .attr("height", 35)
  .attr("fill", "black")
  .style("opacity", 0.8);

tooltip.append("text")
  .attr("x", 50)
  .attr("dy", "1.2em")
  .style("text-anchor", "middle")
  .attr("font-size", "12px")
  .attr("font-weight", "bold")
  .attr("fill", "white");

 tooltip.append("text")
  .attr("x", 50)
  .attr("dy", "2.3em")
  .style("text-anchor", "middle")
  .attr("font-size", "12px")
  .attr("font-weight", "bold")
  .attr("fill", "white");
