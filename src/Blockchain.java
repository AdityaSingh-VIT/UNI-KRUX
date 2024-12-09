import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> chain;
    private int difficulty;

    public Blockchain(int difficulty) {
        this.chain = new ArrayList<>();
        this.difficulty = difficulty;
        
        // Create the genesis block
        addGenesisBlock();
    }

    private void addGenesisBlock() {
        Block genesisBlock = new Block("0", "Genesis Block");
        genesisBlock.mineBlock(difficulty);
        chain.add(genesisBlock);
    }

    public void addBlock(String data) {
        String previousHash = chain.get(chain.size() - 1).getHash();
        Block newBlock = new Block(previousHash, data);
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }

    public boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        // Check genesis block
        if (!chain.get(0).getPreviousHash().equals("0")) {
            return false;
        }

        // Check all blocks
        for (int i = 1; i < chain.size(); i++) {
            currentBlock = chain.get(i);
            previousBlock = chain.get(i - 1);

            // Compare registered hash and calculated hash
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            // Compare previous hash
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                return false;
            }
        }

        return true;
    }

    // Getter for the blockchain
    public List<Block> getChain() {
        return chain;
    }
}