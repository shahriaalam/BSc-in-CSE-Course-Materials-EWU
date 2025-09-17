document.addEventListener("DOMContentLoaded", function () {
  const questions = [
    {
      scene: "You hear a noise from the next train car and you're alone. What do you do?",
      options: [
        { text: "Charge in to help", score: 25 },
        { text: "Stay quiet and observe", score: 15 },
        { text: "Run away fast", score: 5 },
        { text: "Shut the door quietly", score: 10 }
      ]
    },
    {
      scene: "A stranger asks for help while bleeding. What's your reaction?",
      options: [
        { text: "Help immediately", score: 20 },
        { text: "Ask others first", score: 10 },
        { text: "Be cautious but assist", score: 15 },
        { text: "Ignore and move on", score: 5 }
      ]
    },
    {
      scene: "Zombies are closing in. You have one bat. What's your move?",
      options: [
        { text: "Fight them all!", score: 25 },
        { text: "Hold the door for others", score: 20 },
        { text: "Escape alone", score: 5 },
        { text: "Hide silently", score: 10 }
      ]
    },
    {
      scene: "Your team wants to split up. You say...",
      options: [
        { text: "Stick together", score: 20 },
        { text: "Let them decide", score: 10 },
        { text: "Go alone", score: 5 },
        { text: "Lead the way solo", score: 15 }
      ]
    },
    {
      scene: "You made it to the front of the train, but someone begs to be let in...",
      options: [
        { text: "Open the door", score: 25 },
        { text: "Ask others for vote", score: 15 },
        { text: "Deny entry", score: 5 },
        { text: "Watch silently", score: 10 }
      ]
    }
  ];

const results = [
  {
    min: 90,
    name: "🧱 Sang-hwa",
    desc: "You're strong, selfless, and a true protector.",
    img: "image/Sang-hwa.jpg"
  },
  {
    min: 75,
    name: "💼 Seok-woo",
    desc: "You evolve from selfish to heroic when it matters most.",
    img: "image/Seok-woo.webp"
  },
  {
    min: 60,
    name: "⚾ Yong-guk",
    desc: "You're youthful and brave, willing to stand up for others.",
    img: "image/Yong-guk.webp"
  },
  {
    min: 45,
    name: "👧 Su-an",
    desc: "You’re innocent but deeply empathetic and wise beyond your years.",
    img: "image/Su-an.jpeg"
  },
  {
    min: 0,
    name: "👔 Yon-suk",
    desc: "You tend to think about survival first, but there’s always room to grow.",
    img: "image/Yong-suk.webp"
  }
];

  let currentQuestion = 0;
  const answers = [];

  const card = document.getElementById('quiz-card');

function renderQuestion(index) {
  const q = questions[index];
  const selected = answers[index];

  card.innerHTML = `
    <h2>Q${index + 1}/5</h2>
    <p>${q.scene}</p>
    <div class="options">
      ${q.options.map((opt, i) => `
        <button class="${selected === i ? 'selected' : ''}" onclick="selectOption(${i})">${opt.text}</button>
      `).join('')}
    </div>
    <div class="navigation">
      <button onclick="goBack()" ${index === 0 ? "disabled" : ""}>⬅ Back</button>
      <button onclick="goNext()" ${typeof answers[index] === 'undefined' ? "disabled" : ""}>Next ➡</button>
    </div>
  `;
}


  window.selectOption = function(optionIndex) {
    answers[currentQuestion] = optionIndex;
    renderQuestion(currentQuestion);
  }

  window.goBack = function() {
    if (currentQuestion > 0) {
      currentQuestion--;
      renderQuestion(currentQuestion);
    }
  }

  window.goNext = function() {
    if (currentQuestion < questions.length - 1) {
      currentQuestion++;
      renderQuestion(currentQuestion);
    } else {
      showResult();
    }
  }

  function showResult() {
    const totalScore = answers.reduce((acc, selected, i) => {
      return acc + questions[i].options[selected].score;
    }, 0);

    const matched = results.find(r => totalScore >= r.min);

    card.innerHTML = `
      <div class="result">
        <h2>You are: ${matched.name}</h2>
        <img src="${matched.img}" alt="${matched.name}">
        <p>${matched.desc}</p>
        <p>Total Score: <strong>${totalScore}</strong></p>
        <button onclick="restart()">🔁 Try Again</button>
      </div>
    `;
  }

  window.restart = function() {
    currentQuestion = 0;
    answers.length = 0;
    renderQuestion(currentQuestion);
  }

  // Start the quiz
  renderQuestion(currentQuestion);
});
