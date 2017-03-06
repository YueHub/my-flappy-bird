package com.myflappybird.main;

import com.myflappybird.control.PlayerControl;
import com.myflappybird.dto.GameDto;
import com.myflappybird.ui.GameFrame;
import com.myflappybird.ui.GamePanel;

public class GameMain {
	public static void main(String[] args){
		GameDto dto = new GameDto();
		GamePanel gamepanel = new GamePanel(dto); 
		gamepanel.setPlayerControl(new PlayerControl(dto));
		new GameFrame(gamepanel,dto);
	}
}
