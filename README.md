# Tapping_pad_game
![메인 화면 이미지](./1.jpg)

Tapping Pad는 JAVA로 작성된 미니 게임입니다.
화면은 JFrame GUI를, 게임 동작에는 Thread 등을 이용하여 제작하였습니다.

사용자는 메인 화면에서 3가지 버튼(Game Start, See Ranking, Exit)을 이용하여 각 기능들을 수행할 수 있습니다.

![2](./2.jpg)

먼저 사용자가 Game Start 버튼을 눌렀을 때 동작입니다.
9개의 Pad 중, 하나의 Pad가 랜덤으로 검은색으로 변하고, Pad 안의 시간이 점점 줄어듭니다.

이 때, 시간이 되기 전 사용자가 Pad를 클릭하면, Score가 오르고 다른 랜덤 Pad가 다시 검정색으로 변하게 됩니다
