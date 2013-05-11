package sag.com.websocket.simple;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

/**
 * Created with IntelliJ IDEA.
 * User: Augie
 * Date: 4/6/13
 * Time: 3:39 PM
 * <p/>
 * Modification:
 * ----------------------------
 */

@WebServlet(urlPatterns = "/testWebsocket")
public class TestWebSocket extends WebSocketServlet {

    private static final long serialVersionUId = 1L;
    @Override
    protected StreamInbound createWebSocketInbound(String s,HttpServletRequest request) {

        return new MessageInbound() {
            @Override
            protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            protected void onTextMessage(CharBuffer charBuffer) throws IOException {
                System.out.println(charBuffer.toString());
                WsOutbound outbound = getWsOutbound();
                String str = "Test has been printed in the server";
                /*int strLen = str.length();
                CharBuffer chBuffer = CharBuffer.allocate(strLen);
                for(char c:str.toCharArray()){
                    chBuffer.put(c);
                }
                chBuffer.flip();*/
                CharBuffer chBuffer = CharBuffer.wrap(str);
                outbound.writeTextMessage(chBuffer);
            }
        };
    }
}
