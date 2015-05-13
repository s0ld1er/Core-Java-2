import java.io.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.*;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.brush.*;
import syntaxhighlighter.example.Example;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.theme.ThemeRDark;

public class Highliter {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushXml());
                parser.setHtmlScript(true);
                parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(), new BrushJScript(), new BrushPhp()));

                SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeRDark());
                highlighter.setFirstLine(1);
                highlighter.setHighlightedLineList(Arrays.asList(1, 2, 22, 23, 45));
                try {
                    highlighter.setContent(new File("D:/example.txt"));
                } catch (IOException ex) {
                    Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(highlighter);
                frame.setLocationByPlatform(true);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
