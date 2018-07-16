package ranger.one.ranger.decorder;

import java.util.HashMap;

public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator(IPacketCreator c) {
        super(c);
    }

    /**
     * @return
     */
    @Override
    public String handleContent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cache-Control:no-cache\n");
        stringBuffer.append(component.handleContent());
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        IPacketCreator pc = new PacketHTMLHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));

        HashMap
    }



}
