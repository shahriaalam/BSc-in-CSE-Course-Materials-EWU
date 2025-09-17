
// 1 no

function isFieldMissing(input) {
  if (input.trim() === "") 
  {
    return "Missing";
  } 
  else {
    return "OK";
  }
}

console.log(isFieldMissing(""));
console.log(isFieldMissing(" "));  
console.log(isFieldMissing("John Doe"));



// 2 no
function extractSkills(skillsString) {
    return skillsString.split(',').map(skill => skill.trim().toLowerCase());
}

console.log(extractSkills("JavaScript, Python, HTML,css , node.js "));

// 3 no
function getInitials(fullName) {
  const parts = fullName.split(' ');
  const filter = parts.filter(part => !(part.length === 1 || part.endsWith('.')));
  const initials = filter.map(part => part[0]).join('.') + '.';
  return initials;
}

console.log(getInitials("Sadia K. Rahman"));
console.log(getInitials("Hasibul Islam")); 


// 4 no
function formatHeadline(headline) {
  return headline
    .split(' ')
    .map(word => {
      if (word.length === 0) return word;
      return word[0].toUpperCase() + word.slice(1).toLowerCase();
    })
    .join(' ');
}
console.log(formatHeadline("full stack DEVELOPER & javascript ENTHUSIAST")); 


// 5 no
function preferredLocations(locationsArray, n) {
  if (n === undefined) {
    return locationsArray.length > 0 ? [locationsArray[0]] : [];
  }
  if (n < 0) {
    return [];
  }
  return locationsArray.slice(0, n);
}

console.log(preferredLocations(["Dhaka", "Sylhet", "Barisal"], 2));
console.log(preferredLocations(["Dhaka"], -1));


// 6 no
function findSkillPair(skills, targetLength) {
  for (let i = 0; i < skills.length - 1; i++) {
    const combinedLength = skills[i].length + skills[i + 1].length;
    if (combinedLength === targetLength) {
      return [i, i + 1];
    }
  }
  return null;
}
console.log(findSkillPair(["java", "python", "js", "html"], 10)); 


// 7 no
function rearrangeSkill(skills, fromIndex, toIndex) {
  const arr = [...skills];
  const [movedSkill] = arr.splice(fromIndex, 1);
  arr.splice(toIndex, 0, movedSkill);
  return arr;
}

console.log(rearrangeSkill(["html", "css", "js", "react"], 0, 2)); 


// 8 no
function analyzeResume(candidate) {

  function toTitleCase(str) {
    return str
      .toLowerCase()
      .split(' ')
      .filter(word => word)
      .map(word => word[0].toUpperCase() + word.slice(1))
      .join(' ');
  }


  const cleanedName = candidate.name ? candidate.name.trim() : '';
  const cleanedEmail = candidate.email ? candidate.email.trim() : '';
  const email = cleanedEmail === '' ? null : cleanedEmail; 

 
  const skillsArray = candidate.skills
    ? candidate.skills
        .split(',')
        .map(skill => skill.trim().toLowerCase())
        .filter(skill => skill) 
    : [];

  
  const headline = candidate.headline ? toTitleCase(candidate.headline.trim()) : '';

 
  return {
    ...candidate,
    name: cleanedName,
    email: email,
    skills: skillsArray,
    headline: headline,
  };
}

const candidate = {
  name: " Nahid Islam ",
  email: " ",
  skills: "JavaScript, Python, HTML,css , node.js ",
  headline: " aspiring FULLSTACK developer ",
  projects: ["ecommerce", "gamebot", "portfolio", "chatapp"]
};
console.log(analyzeResume(candidate));
