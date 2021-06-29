
let edu_counter = 0;
let prlink_counter =0;
let exp_counter = 0;
let skill_counter=0;
let project_counter =0;
let ach_counter =0;
let ref_counter =0;
function addProfile(){
	var select = document.createElement("select");
	select.setAttribute("class","form-select");
	select.setAttribute("id","inputGroupSelect02");
	prlink_counter++;
	let name = "profile_links["+prlink_counter+"].website";
	select.setAttribute("name",name);
	let options = [], optionnames = ["LinkedIn","Github","Facebook","Twitter","Youtube"];
	for(let i=0;i<=4;i++){
		options[i] = document.createElement("option");
		options[i].setAttribute("value", optionnames[i]);
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
	input.setAttribute("name","profile_links["+prlink_counter+"].link");
	di.appendChild(select);
	di.appendChild(input);
			
	doc.appendChild(di);
}



function addEducation(){
	var doc = document.getElementById("educations");
		
	let disrow = document.createElement("div");
	disrow.setAttribute("class","row");
	let dis=[];
	for(let i=0;i<=6;i++){
		dis[i] = document.createElement("div");
		dis[i].setAttribute("class","form-group mb-3 col-6");
	}

	let inputs=[];
	let icons=[];
	let labels=[];
	let input_name = ["institute","nameOfDegree", "startingYear","endingYear","grade","additionalInfo"];
	edu_counter++;
	for(let i=0;i<=6;i++){
		inputs[i]=document.createElement("input");
		inputs[i].setAttribute("type","text");
		inputs[i].setAttribute("class","form-control");
		if(i<5){
			let name_value = "educations["+edu_counter+"]."+input_name[i];
			inputs[i].setAttribute("name",name_value);
		}
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
	labels[6].appendChild(document.createTextNode("Additional Information"));
		
	var select = document.createElement("select");
	select.setAttribute("class","form-select");
	select.setAttribute("id","inputGroupSelect02");
	select.setAttribute("name", "educations["+edu_counter+"].gradeType");
	let options=[]; let opnames=["GPA","CGPA"];
	for(let i=0;i<2;i++){
		options[i] = document.createElement("option");
		options[i].setAttribute("value",opnames[i]);
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

	let textarea = document.createElement("textarea");
	textarea.setAttribute("rows","2");
	textarea.setAttribute("type","text");
	textarea.setAttribute("class","form-control");
	textarea.setAttribute("aria-label","With textarea");
	name_value = "educations["+edu_counter+"]."+input_name[5];
	textarea.setAttribute("name",name_value);
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
	doc.appendChild(document.createElement("br"));
}


function addExperience(){
		
	var doc = document.getElementById("experience");

	let disrow = document.createElement("div");
	disrow.setAttribute("class","row");
	let dis=[];
	for(let i=0;i<=4;i++){
		dis[i] = document.createElement("div");
		dis[i].setAttribute("class","form-group mb-3 col-6");
	}
	exp_counter++;
	let inputs=[];
	let icons=[];
	let labels=[];
	let input_names = ["companyName", "position","startYear", "endYear","description"];
	for(let i=0;i<=4;i++){
		inputs[i]=document.createElement("input");
		inputs[i].setAttribute("type","text");
		inputs[i].setAttribute("class","form-control");
		let name= "experience["+exp_counter+"]."+input_names[i];
		inputs[i].setAttribute("name",name);
		icons[i] = document.createElement("i");
		labels[i] = document.createElement("label");
	}
	icons[0].setAttribute("class","fa fa-university");
	icons[1].setAttribute("class","fa fa-user");
	icons[2].setAttribute("class","fa fa-calendar");
	icons[3].setAttribute("class","fa fa-calendar");
	icons[4].setAttribute("class","fa fa-pencil");
		
	labels[0].appendChild(document.createTextNode("Name of the Company"));
	labels[1].appendChild(document.createTextNode("Current Position"));
	labels[2].appendChild(document.createTextNode("Starting Year"));
	labels[3].appendChild(document.createTextNode("Ending Year / Currently Working"));
	labels[4].appendChild(document.createTextNode("Description"));
	
	dis[0].appendChild(icons[0]);dis[0].appendChild(labels[0]); dis[0].appendChild(inputs[0]);
	dis[1].appendChild(icons[1]);dis[1].appendChild(labels[1]); dis[1].appendChild(inputs[1]);
	dis[2].appendChild(icons[2]);dis[2].appendChild(labels[2]); dis[2].appendChild(inputs[2]);
	dis[3].appendChild(icons[3]);dis[3].appendChild(labels[3]); dis[3].appendChild(inputs[3]);
	dis[4].appendChild(icons[4]);dis[4].appendChild(labels[4]);

	let textarea = document.createElement("textarea");
	textarea.setAttribute("rows","2");
	textarea.setAttribute("type","text");
	textarea.setAttribute("class","form-control");
	let name = "experience["+exp_counter+"]."+input_names[4];
	textarea.setAttribute("name",name);
	textarea.setAttribute("aria-label","With textarea");
	dis[4].setAttribute("class","form-group");
	dis[4].appendChild(textarea);

	disrow.appendChild(dis[0]);
	disrow.appendChild(dis[1]);
	disrow.appendChild(dis[2]);
	disrow.appendChild(dis[3]);
	disrow.appendChild(dis[4]);
	doc.appendChild(disrow);
	doc.appendChild(document.createElement("br"));
	doc.appendChild(document.createElement("br"));
}



function addSkills(){
	var doc = document.getElementById("skills");
	skill_counter++;
	let disrow = document.createElement("div");
	disrow.setAttribute("class","row");
	let dis=[];
	for(let i=0;i<=1;i++){
		dis[i] = document.createElement("div");
		dis[i].setAttribute("class","form-group mb-3 col-6");
	}

	let inputs=[];
	let icons=[];
	let labels=[];
	let namearr = ["category","skillName"];
	for(let i=0;i<=1;i++){
		inputs[i]=document.createElement("input");
		inputs[i].setAttribute("type","text");
		inputs[i].setAttribute("class","form-control");
		let name = "skills["+skill_counter+"]."+namearr[i];
		inputs[i].setAttribute("name", name);
		icons[i] = document.createElement("i");
		labels[i] = document.createElement("label");
	}
	icons[0].setAttribute("class","fa fa-star");
	icons[1].setAttribute("class","fa fa-paint-brush");
	
	labels[0].appendChild(document.createTextNode(" Catagory"));
	labels[1].appendChild(document.createTextNode(" Skills"));
	
	dis[0].appendChild(icons[0]);dis[0].appendChild(labels[0]); dis[0].appendChild(inputs[0]);
	dis[1].appendChild(icons[1]);dis[1].appendChild(labels[1]); dis[1].appendChild(inputs[1]);

	disrow.appendChild(dis[0]);
	disrow.appendChild(dis[1]);
	doc.appendChild(disrow);
}



function addProject(){
		
	var doc = document.getElementById("project");
	project_counter++;
	let disrow = document.createElement("div");
	disrow.setAttribute("class","row");
	let dis=[];
	for(let i=0;i<=4;i++){
		dis[i] = document.createElement("div");
		dis[i].setAttribute("class","form-group mb-3 col-6");
	}

	let inputs=[];
	let icons=[];
	let labels=[];
	let namearr= ["name", "toolUsed", "link", "description"];
	for(let i=0;i<=3;i++){
		inputs[i]=document.createElement("input");
		inputs[i].setAttribute("type","text");
		inputs[i].setAttribute("class","form-control");
		let name = "projects["+project_counter+"]."+namearr[i];
		inputs[i].setAttribute("name",name);
		icons[i] = document.createElement("i");
		labels[i] = document.createElement("label");
	}
	icons[0].setAttribute("class","fa fa-database");
	icons[1].setAttribute("class","fa fa-paint-brush");
	icons[2].setAttribute("class","fa fa-link");
	icons[3].setAttribute("class","fa fa-pencil");
				
	labels[0].appendChild(document.createTextNode("Name of the Project"));
	labels[1].appendChild(document.createTextNode("Tools Used"));
	labels[2].appendChild(document.createTextNode("Project Link"));
	labels[3].appendChild(document.createTextNode("Description"));
		
	dis[0].appendChild(icons[0]);dis[0].appendChild(labels[0]); dis[0].appendChild(inputs[0]);
	dis[1].appendChild(icons[1]);dis[1].appendChild(labels[1]); dis[1].appendChild(inputs[1]);
	dis[2].appendChild(icons[2]);dis[2].appendChild(labels[2]); dis[2].appendChild(inputs[2]);
	dis[3].appendChild(icons[3]);dis[3].appendChild(labels[3]);

	let textarea = document.createElement("textarea");
	textarea.setAttribute("rows","2");
	textarea.setAttribute("type","text");
	textarea.setAttribute("class","form-control");
	textarea.setAttribute("aria-label","With textarea");
	let name = "projects["+project_counter+"]."+namearr[3];
	textarea.setAttribute("name",name);
	dis[3].setAttribute("class","form-group");
	dis[3].appendChild(textarea);

	disrow.appendChild(dis[0]);
	disrow.appendChild(dis[1]);
	disrow.appendChild(dis[2]);
	disrow.appendChild(dis[3]);
	doc.appendChild(disrow);
	doc.appendChild(document.createElement("br"));
}


function addAchievement(){
	var doc = document.getElementById("achievement");
	ach_counter++;
	let disrow = document.createElement("div");
	disrow.setAttribute("class","row");
	let dis=[];
	for(let i=0;i<=1;i++){
		dis[i] = document.createElement("div");
		dis[i].setAttribute("class","form-group mb-3 col-6");
	}

	let inputs=[];
	let icons=[];
	let labels=[];
	let namearr= ["name","description"];
	for(let i=0;i<=1;i++){
		inputs[i]=document.createElement("input");
		inputs[i].setAttribute("type","text");
		inputs[i].setAttribute("class","form-control");
		let name = "achievements["+ach_counter+"]."+namearr[i];
		inputs[i].setAttribute("name", name);
		icons[i] = document.createElement("i");
		labels[i] = document.createElement("label");
	}
	icons[0].setAttribute("class","fa fa-trophy");
	icons[1].setAttribute("class","fa fa-pencil");
		
	labels[0].appendChild(document.createTextNode("Achievement"));
	labels[1].appendChild(document.createTextNode("Description"));		

	dis[0].appendChild(icons[0]);dis[0].appendChild(labels[0]); dis[0].appendChild(inputs[0]);
	dis[1].appendChild(icons[1]);dis[1].appendChild(labels[1]);

	let textarea = document.createElement("textarea");
	textarea.setAttribute("rows","2");
	textarea.setAttribute("type","text");
	textarea.setAttribute("class","form-control");
	textarea.setAttribute("aria-label","With textarea");
	let name ="achievements["+ach_counter+"]."+namearr[1];
	textarea.setAttribute("name",name);
	dis[1].setAttribute("class","form-group");
	dis[1].appendChild(textarea);

	disrow.appendChild(dis[0]);
	disrow.appendChild(dis[1]);
	doc.appendChild(disrow);
	doc.appendChild(document.createElement("br"));
}


function addReference(){
	ref_counter++;
	var doc = document.getElementById("reference");

	let disrow = document.createElement("div");
	disrow.setAttribute("class","row");
	let dis=[];
	
	for(let i=0;i<=1;i++){
		dis[i] = document.createElement("div");
		dis[i].setAttribute("class","form-group mb-3 col-6");
	}

	let inputs=[];
	let icons=[];
	let labels=[];
	let namearr= ["name", "description"];
	for(let i=0;i<=1;i++){
		inputs[i]=document.createElement("input");
		inputs[i].setAttribute("type","text");
		inputs[i].setAttribute("class","form-control");
		let name = "reference["+ref_counter+"]."+namearr[i];
		inputs[i].setAttribute("name", name);
		icons[i] = document.createElement("i");
		labels[i] = document.createElement("label");
	}
	icons[0].setAttribute("class","fa fa-group");
	icons[1].setAttribute("class","fa fa-pencil");
	
	labels[0].appendChild(document.createTextNode("Name"));
	labels[1].appendChild(document.createTextNode("Description"));
		
	dis[0].appendChild(icons[0]);dis[0].appendChild(labels[0]); dis[0].appendChild(inputs[0]);
	dis[1].appendChild(icons[1]);dis[1].appendChild(labels[1]);

	let textarea = document.createElement("textarea");
	textarea.setAttribute("rows","2");
	textarea.setAttribute("type","text");
	textarea.setAttribute("class","form-control");
	textarea.setAttribute("aria-label","With textarea");
	let name = "reference["+ref_counter+"]."+namearr[1];
	textarea.setAttribute("name",name);
	dis[1].setAttribute("class","form-group");
	dis[1].appendChild(textarea);

	disrow.appendChild(dis[0]);
	disrow.appendChild(dis[1]);
	doc.appendChild(disrow);
	doc.appendChild(document.createElement("br"));
}