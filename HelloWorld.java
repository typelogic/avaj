package org.demo;

import javax.crypto.Cipher;
import javax.imageio.ImageIO;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CardTerminals;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
//public class Block {
class Block {
    private int previousHash;
    private String data;
    private int hash;

    public Block(String data, int previousHash) {
        this.data = data;
        this.previousHash = previousHash;

        // Mix the content of this block with previous hash
        // to create the hash of this new block and that's what
        // makes it block chain
        this.hash = Arrays.hashCode(new Integer[]{data.hashCode(),previousHash});
    }
}

public class HelloWorld {
    public static void main (String[] args) throws Exception {
        System.out.println("hello world");

        TerminalFactory terminalFactory = TerminalFactory.getDefault();
        CardTerminals cardTerminals = terminalFactory.terminals();
        int n = cardTerminals.list().size();
        System.out.println("n = " + n);
        if (n > 0) {
            CardTerminal cardTerminal = cardTerminals.list().get(0);
        }
       
        char arr[] = new char[13];
        arr[0] = 5;
        System.out.println("arr size = " + arr.length);
        //System.out.println("arr content count = " + arr.size);

        testBlockchain();
    }

    static void testBlockchain() {
        List<Block> blockChainList = new ArrayList<>();
        Block genesis = new Block("BlockChain",0);
        blockChainList.add(genesis);

        Block helloBlock = new Block("Hello",
            blockChainList.get(blockChainList.size()-1).getHash());
        blockChainList.add(helloBlock);

        blockChainList.forEach(System.out::println);
    }
}
