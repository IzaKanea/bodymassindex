# Body Mass Index calculator
 <h3>A RESTful API</h3>

 <h4>Purpose </h4>
 <p>
 This project is a part of my online documentation to keep solutions hand on. Anyone who need it can use it as he wish.
<p/>
<h4>Description</h4>
 <p>
 Body Mass Index calculator using Restful Web Services to give you your Body Mass Index. Enter your height in meters and weight in kilograms and you'll receive your bmi.<p>
  <p>
  It's able to use get, post, put, delete and options methods.
 The form or path parameters can be used to pass values. The possible responses type are JSON, XML, HTML and TEXT PLAIN.</p>
 
 <p>Some annotations like <b>@Produces</b> and <b>@Consumes</b> are used</p>
 
 <h4>How it's works?</h4>
 
 <h5>1. Creating user, database and table</h5>
 <p> 
 CREATE SCHEMA `bmi_historic` ;<p/>
<p> 
CREATE USER 'test'@'localhost' IDENTIFIED BY 'pass';<p/>
<p> 
 GRANT ALL PRIVILEGES ON bmi_historic.* TO 'test'@'localhost';<p/>
<p> 
CREATE TABLE `bmi_historic`.`BMIHistoric` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `height` DECIMAL(4,2),
  `weight`DECIMAL(5,2),
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);<p/>
 
 
 <h5>2. Executing OptionsClient.java to see available options</h5>
 <p><b>output</b><p/>
 <p>{Keep-Alive=[timeout=20], Connection=[keep-alive], Content-Length=[0], Date=[Sat, 15 Feb 2020 22:09:11 GMT], Allow=[POST, PUT, GET, DELETE, OPTIONS]}<p/>

 <h5>3. Executing InsertClient.java to populate BMIHistoric table</h5>
 
 <p><b>output</b><p/>

 &lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?&gt;&lt;record&gt;&lt;bmi&gt;19.38&lt;/bmi&gt;&lt;date&gt;15/02/2020 22:51:14&lt;/date&gt;&lt;height&gt;1.59&lt;/height&gt;&lt;id&gt;1&lt;/id&gt;&lt;weight&gt;49.0&lt;/weight&gt;&lt;/record&gt;<br/>&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?&gt;&lt;record&gt;&lt;bmi&gt;19.29&lt;/bmi&gt;&lt;date&gt;15/02/2020 22:51:14&lt;/date&gt;&lt;height&gt;1.61&lt;/height&gt;&lt;id&gt;2&lt;/id&gt;&lt;weight&gt;50.0&lt;/weight&gt;&lt;/record&gt;<br/>
 <b>...</b>
 
 <h5>4. Executing UpdateClient.java to update the fifth entry</h5>

 <p><b>from :</b></p>
 <p>&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?&gt;&lt;record&gt;&lt;bmi&gt;18.93&lt;/bmi&gt;&lt;date&gt;15/02/2020 22:51:14&lt;/date&gt;&lt;height&gt;1.72&lt;/height&gt;&lt;id&gt;5&lt;/id&gt;&lt;weight&gt;56.0&lt;/weight&gt;&lt;/record&gt;</p>
 <p><b>to :</b></p>
 <p>&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?&gt;&lt;record&gt;&lt;bmi&gt;24.69&lt;/bmi&gt;&lt;date&gt;15/02/2020 23:03:13&lt;/date&gt;&lt;height&gt;1.8&lt;/height&gt;&lt;id&gt;5&lt;/id&gt;&lt;weight&gt;80.0&lt;/weight&gt;&lt;/record&gt;</p>
 
  <h5>5. Executing DeleteClient.java to delete the ninth entry</h5>
   <p><b>output</b><p/>
    
  <p>
 <b>...</b><br/>
 historic : [ ID : 8, HEIGHT : 1.87, WEIGHT : 84.0, BMI : 24.02, DATE : 15/02/2020 22:51:14 ]<br/>
historic : [ ID : 10, HEIGHT : 1.95, WEIGHT : 112.0, BMI : 29.45, DATE : 15/02/2020 22:51:14 ]

</p>
  <h5>6. Executing SelectClient.java to select entries with different types</h5>
 <p><b>JSON</b></p>
<p>[{"id":1,"height":1.59,"weight":49.0,"<b>....</b>]</p>

<p><b>XML</b></p>
<p>&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?&gt;&lt;bMIHistorics&gt;&lt;record&gt;&lt;bmi&gt;19.<b>....</b>&lt;/bMIHistorics&gt;</p>

<p><b>HTML</b></p>
<p>&lt;html&gt;&lt;head&gt;&lt;title&gt;Body Mass Index calculator&lt;/title&gt;&lt;/head&gt;&lt;h1&gt;Body Mass Index calculator&lt;/h1&gt;&lt;body&gt;&lt;fieldset&gt;&lt;legend&gt;Hystoric 15/02/2020 22:51:14&lt;/legend&gt;&lt;ul&gt;&lt;li&gt; ID : 1&lt;/li&gt;&lt;li&gt; HEIGHT : 1.59&lt;/li&gt;&lt;li&gt; WEIGHT : 49.0&lt;/li&gt;&lt;li&gt; BMI : 19.38<b>....</b>&lt;/body&gt;&lt;/html&gt;</p>

<p><b>TEXT PLAIN</b></p>
<p>historic : [ ID : 1, HEIGHT : 1.59, WEIGHT : 49.0, BMI : 19.38, <b>....</b> ]</p>

<p><b>XML - select one by id </b></p>
<p>&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?&gt;&lt;record&gt;&lt;bmi&gt;19.38&lt;/bmi&gt;&lt;date&gt;15/02/2020 22:51:14&lt;/date&gt;&lt;height&gt;1.59&lt;/height&gt;&lt;id&gt;1&lt;/id&gt;&lt;weight&gt;49.0&lt;/weight&gt;&lt;/record&gt;</p>

 <p></p>
 
