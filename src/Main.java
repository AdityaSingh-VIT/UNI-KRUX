public class Main {
    public static void main(String[] args) {
        // Initialize blockchain with a difficulty of 4
        Blockchain votingBlockchain = new Blockchain(4);

        // Simulate voting process
        System.out.println("Starting Blockchain Voting System...");

        // Add votes as blocks
        votingBlockchain.addBlock("Candidate A: 100 votes");
        votingBlockchain.addBlock("Candidate B: 85 votes");
        votingBlockchain.addBlock("Candidate C: 65 votes");

        // Validate the blockchain
        System.out.println("Is blockchain valid? " + votingBlockchain.isChainValid());

        // Print blockchain details
        System.out.println("\nBlockchain Details:");
        for (int i = 0; i < votingBlockchain.getChain().size(); i++) {
            Block block = votingBlockchain.getChain().get(i);
            System.out.println("Block " + i + " - Hash: " + block.getHash());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Data: " + block.getData());
            System.out.println();
        }
    }
}