	function addProfile(){
		
				var select = document.createElement("select");
				var option1 = document.createElement("option");
				var option2 = document.createElement("option");
				var option3 = document.createElement("option");
				var option4 = document.createElement("option");
				var option5 = document.createElement("option");
				var option6 = document.createElement("option");
				
				var input = document.createElement("input");
				var doc = document.getElementById("profilelinks");
				
				var di = document.createElement("div");
				select.setAttribute("class","form-select");
				
				select.setAttribute("id","inputGroupSelect02");
				
				option1.setAttribute("value","1");
				option1.appendChild(document.createTextNode("Select Profile"));
				option2.setAttribute("value","2");
				option2.appendChild(document.createTextNode("LinkedIn"));
				option4.setAttribute("value","3");
				option3.appendChild(document.createTextNode("Github"));
				option4.setAttribute("value","4");
				option4.appendChild(document.createTextNode("Facebook"));
				option5.setAttribute("value","5");
				option5.appendChild(document.createTextNode("Twitter"));
				option6.setAttribute("value","6");
				option6.appendChild(document.createTextNode("Youtube"));
				
				di.setAttribute("class","input-group mb-3");
				
				select.appendChild(option1); select.appendChild(option2); select.appendChild(option3); select.appendChild(option4);
				select.appendChild(option5); select.appendChild(option6);
				input.setAttribute("type","text");
				input.setAttribute("class","form-control");
				input.setAttribute("placeholder","Profile URL");

	
				di.appendChild(select);
				di.appendChild(input);
				
				doc.appendChild(di);
	}
	function addEducation(){
		var doc = document.getElementById("educations");
		// for div tags
		let dis=[];
		for(let i=0;i<5;i++){
			dis[i] = document.createElement("div");
			dis[i].setAttribute("class","input-group mb-3");
		}
		//for input tags
		let inputs=[]; let inputnames = [" ","Degree Name","Subject / Group","Starting Year","Graduation Year / Present", "Grade"];
		for(let i=0;i<=5;i++){
			inputs[i]=document.createElement("input");
			inputs[i].setAttribute("type","text");
			inputs[i].setAttribute("class","form-control");
			inputs[i].setAttribute("placeholder",inputnames[i]);
		}
		
		var span = document.createElement("span");
		span.setAttribute("class","input-group-text"); span.setAttribute("id","basic-addon1");
		span.appendChild(document.createTextNode("Name of the Institution"));
		
		var select = document.createElement("select");
		select.setAttribute("class","form-select");
		select.setAttribute("id","inputGroupSelect02");
		let options=[]; let opnames=["Select Grading System","GPA","CGPA"];
		for(let i=0;i<3;i++){
			options[i] = document.createElement("option");
			options[i].setAttribute("value",i);
			options[i].appendChild(document.createTextNode(opnames[i]));
			select.appendChild(options[i]);
		}
		dis[0].appendChild(span); dis[0].appendChild(inputs[0]);
		dis[1].appendChild(inputs[1]); dis[1].appendChild(inputs[2]);
		dis[2].appendChild(inputs[3]); dis[2].appendChild(inputs[4]);
		dis[3].appendChild(select); dis[3].appendChild(inputs[5]);
		//di.appendChild(span); di.appendChild(input);
		//di2.appendChild(input2); di2.appendChild(input3);
		let span2 = document.createElement("span"); 
		span2.setAttribute("class","input-group-text");
		span2.appendChild(document.createTextNode("Additional Information"));
		let textarea = document.createElement("textarea");
		textarea.setAttribute("rows","2");
		textarea.setAttribute("class","form-control");
		textarea.setAttribute("aria-label","With textarea");
		dis[4].setAttribute("class","input-group");
		dis[4].appendChild(span2); dis[4].appendChild(textarea);
		
		doc.appendChild(dis[0]);
		doc.appendChild(dis[1]);
		doc.appendChild(dis[2]);
		doc.appendChild(dis[3]);
		doc.appendChild(dis[4]);
		doc.appendChild(document.createElement("br"));
		//doc.appendChild(di);
		//doc.appendChild(di2);
	}