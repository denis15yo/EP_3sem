package by.bsu.view.panels;

import by.bsu.events.GameLoopTimerEvent;
import by.bsu.events.GameOverEvent;
import by.bsu.interfaces.Observer;
import by.bsu.models.Game;
import by.bsu.models.Player;
import by.bsu.models.car.TypeCar;
import by.bsu.models.road.TypeRoad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EventObject;

public class GamePanel extends JPanel implements Observer {
    private final Game game;

    public GamePanel() {
        Player player = new Player("Denis", TypeCar.SPORT_CAR);
        game = new Game(TypeRoad.FIRST, player, 2);

        setPreferredSize(new Dimension(game.getWidth(), game.getHeight()));

        setFocusable(true);

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_LEFT){
                    game.hMovePlayer(-10);
                }
                else if(e.getExtendedKeyCode() == KeyEvent.VK_RIGHT){
                    game.hMovePlayer(10);
                }
                else if(e.getExtendedKeyCode() == KeyEvent.VK_UP){
                    game.changeSpeed(1);
                }
                else if(e.getExtendedKeyCode() == KeyEvent.VK_DOWN){
                    game.changeSpeed(-1);
                }
            }
        });

        game.addObserver(this);

        game.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.draw(g);
    }

    @Override
    public void update(EventObject eventObject) {
        if(eventObject instanceof GameLoopTimerEvent){
            repaint();
        } else if(eventObject instanceof GameOverEvent){
            if(eventObject.getSource() instanceof Game){
                Game game = (Game) eventObject.getSource(); // TODO: 5/25/20
            }
            JOptionPane.showMessageDialog(null, game.getPlayer().getName() + ", ыы проиграли и прошли дистанцию: ");
        }
    }
}