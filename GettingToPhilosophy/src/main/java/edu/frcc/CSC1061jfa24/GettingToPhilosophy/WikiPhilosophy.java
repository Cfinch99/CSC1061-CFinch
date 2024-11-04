package edu.frcc.CSC1061jfa24.GettingToPhilosophy;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        testConjecture(destination, source, 20);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, int limit) throws IOException {
        Document doc = null;
        Connection conn = Jsoup.connect(source);
        int count = 0;
        try 
        {
            doc = conn.get();
        }
        catch (Exception e)
        {
            System.out.println("Could not open page. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }

        // select the content text and pull out the paragraphs.
        Element content = doc.getElementById("mw-content-text");
        Elements paragraphs = content.select("p");

        for (Element para : paragraphs) {
            Iterable<Node> iter = new WikiNodeIterable(para);
            for (Node node : iter) {
            	if(node.absUrl("href").equals(destination)) {
            		System.out.println(node.attr("href"));
            		System.out.println("Made it to philosophy in " + (20 - limit) + (" links"));
            		return;
            	}
            	if(limit == 0) {
            		System.out.println("Did not make it to philosophy within 20 links");
            		return;
            	}
            	if(node instanceof TextNode) {
            		String txt = ((TextNode) node).getWholeText();
            		
            		for(int i = 0; i < txt.length(); i++) {
            			if (txt.charAt(i) == '(') {
            				count++;
            			}
            			if (txt.charAt(i) == ')') {
            				count--;
            			}
            		}
            	}
            	if (count == 0 && !node.attr("href").isBlank()) {
            		System.out.println(node.attr("href"));
            		testConjecture(destination, node.absUrl("href"), limit - 1);
            		return;
            		}
            	
            	
            	
            	// personal notes and reminders
            	
                // check for link != null
            	// check parantheses stack
            	// does not start with #
            	// print url
            	// go until find philo or hit limit
            	// then follow link recursively call testConjecture
            	// node.attr? node.attr("href")
            	// if node instanceof TextNode
            
            	
            	
                // TODO: FILL THIS IN!
            	// base case philosphy or limit
            	// if in text node(instanfeoftextnode) and
            	//  if link and not in paranthesis, follow link
            	// node.attr("href") is a link
            	// use a stack for paranth, push on open, pop on close, follow link if empty
            	// or use count, ++ on open, -- on close
            	
            	// If this node is a text node make sure you are not within parentheses
            	
            	// If this node has a link you can get it by accessing the href attribute in the node
            	
            	// If the link is not null and not an empty string and does not start with a # sign 
            	// and is not within parentheses, follow the link recursively by calling testConjecture() 
            	// until you reach your objective or run past the limit. 
            }

        }
    }
}
