	function addProfile(){
		
				var select = document.createElement("select");
				select.setAttribute("class","form-select");
				select.setAttribute("id","inputGroupSelect02");
				let options = [], optionnames = ["Select Profile","LinkedIn","Github","Facebook","Twitter","Youtube"];
				for(let i=0;i<6;i++){
					options[i] = document.createElement("option");
					options[i].setAttribute("value", i);
					options[i].appendChild(document.createTextNode(optionnames[i]));
					select.appendChild(options[i]);
				}
				var input = document.createElement("input");
				var doc = document.getElementById("profilelinks");
				var di = document.createElement("div");
				
				di.setAttribute("class","input-group mb-3");

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
		let disrow = document.createElement("div");
		disrow.setAttribute("class","row");
		let dis=[];
		for(let i=0;i<=6;i++){
			dis[i] = document.createElement("div");
			dis[i].setAttribute("class","form-group mb-3 col-6");
		}
		//for input tags
		let inputs=[];
		let icons=[];
		let labels=[];
		for(let i=0;i<=6;i++){
			inputs[i]=document.createElement("input");
			inputs[i].setAttribute("type","text");
			inputs[i].setAttribute("class","form-control");
			icons[i] = document.createElement("i");
			labels[i] = document.createElement("label");
		}
		icons[0].setAttribute("class","fa fa-university");
		icons[1].setAttribute("class","fa fa-certificate");
		icons[2].setAttribute("class","fa fa-calendar");
		icons[3].setAttribute("class","fa fa-calendar");
		icons[4].setAttribute("class","fa fa-graduation-cap");
		icons[5].setAttribute("class","fa fa-graduation-cap");
		icons[6].setAttribute("class","fa fa-pencil");
		
		
		labels[0].appendChild(document.createTextNode("Institution Name"));
		labels[1].appendChild(document.createTextNode("Name of Degree"));
		labels[2].appendChild(document.createTextNode("Starting Year"));
		labels[3].appendChild(document.createTextNode("Ending Year"));
		labels[4].appendChild(document.createTextNode("CGPA/GPA"));
		labels[5].appendChild(document.createTextNode("Grade"));
		labels[6].appendChild(document.createTextNode("Additional Info"));
		
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
		
		dis[0].appendChild(icons[0]);dis[0].appendChild(labels[0]); dis[0].appendChild(inputs[0]);
		dis[1].appendChild(icons[1]);dis[1].appendChild(labels[1]); dis[1].appendChild(inputs[1]);
		dis[2].appendChild(icons[2]);dis[2].appendChild(labels[2]); dis[2].appendChild(inputs[2]);
		dis[3].appendChild(icons[3]);dis[3].appendChild(labels[3]); dis[3].appendChild(inputs[3]);
		dis[4].appendChild(icons[4]);dis[4].appendChild(labels[4]); dis[4].appendChild(select);
		dis[5].appendChild(icons[5]);dis[5].appendChild(labels[5]); dis[5].appendChild(inputs[4]);
		dis[6].appendChild(icons[6]);dis[6].appendChild(labels[6]);
		//di.appendChild(span); di.appendChild(input);
		//di2.appendChild(input2); di2.appendChild(input3);

		let textarea = document.createElement("textarea");
		textarea.setAttribute("rows","2");
		textarea.setAttribute("type","text");
		textarea.setAttribute("class","form-control");
		textarea.setAttribute("aria-label","With textarea");
		dis[6].setAttribute("class","form-group");
		dis[6].appendChild(textarea);

		disrow.appendChild(dis[0]);
		disrow.appendChild(dis[1]);
		disrow.appendChild(dis[2]);
		disrow.appendChild(dis[3]);
		disrow.appendChild(dis[4]);
		disrow.appendChild(dis[5]);
		disrow.appendChild(dis[6]);
		doc.appendChild(disrow);
		doc.appendChild(document.createElement("br"));
		//doc.appendChild(di);
		//doc.appendChild(di2);
	}
	function addSkills(){
		
	}