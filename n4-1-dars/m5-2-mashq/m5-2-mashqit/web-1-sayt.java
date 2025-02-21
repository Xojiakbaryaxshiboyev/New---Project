let score = 0;
let balloonInterval;
let balloons = [];
const balloonContainer = document.getElementById('balloon-container');
const scoreDisplay = document.getElementById('score');
const startButton = document.getElementById('start-btn');

// O'yinni boshlash
startButton.addEventListener('click', () => {
    score = 0;
    scoreDisplay.textContent = Ballonlar: ${score};
    startGame();
});

function startGame() {
    balloonInterval = setInterval(createBalloon, 1000);  // Har bir sekundda yangi ballon yaratish
    startButton.disabled = true;  // Boshlash tugmasini o'chirish
}

function createBalloon() {
    const balloon = document.createElement('div');
    balloon.classList.add('balloon');
    
    // Ballon tasodifiy joylashadi
    const randomPosition = Math.random() * 90;  // 0-90% gacha bo'lgan tasodifiy joy
    balloon.style.left = randomPosition + '%';
    
    balloon.addEventListener('click', () => {
        balloonPop(balloon);
    });

    balloonContainer.appendChild(balloon);
    
    // Ballonni yuqoriga ko'tarish animatsiyasi
    setTimeout(() => {
        balloon.style.animation = 'rise 4s linear infinite';
    }, 100);
}

function balloonPop(balloon) {
    balloon.remove();  // Ballonni olib tashlash
    score += 1;  // Ballonni patlatganida ball olish
    scoreDisplay.textContent = Ballonlar: ${score};
}

// Ballonlar uchishi uchun animatsiya qo'shish
@keyframes rise {
    0% { bottom: -100px; }
    100% { bottom: 100%; }
}