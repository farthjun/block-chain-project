package org.com.fisco;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class SupplyChain3 extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b50610f37806100206000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630f7ee1ec1461007d5780631c7c37f714610124578063219749991461013b5780632813d19d146101885780632d339b1e14610261578063e6a9df23146102a4575b600080fd5b34801561008957600080fd5b506100a8600480360381019080803590602001909291905050506102fd565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390f35b34801561013057600080fd5b50610139610376565b005b34801561014757600080fd5b50610186600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061051d565b005b34801561019457600080fd5b506101b360048036038101908080359060200190929190505050610872565b60405180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b8381101561022557808201518184015260208101905061020a565b50505050905090810190601f1680156102525780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b34801561026d57600080fd5b506102a2600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061095d565b005b3480156102b057600080fd5b506102fb600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803515159060200190929190505050610d0f565b005b60008181548110151561030c57fe5b90600052602060002090600302016000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060020154905083565b60008060009150600090505b6000805490508110156104d5573373ffffffffffffffffffffffffffffffffffffffff166000828154811015156103b557fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561042d5760008181548110151561041257fe5b906000526020600020906003020160020154820391506104c8565b3373ffffffffffffffffffffffffffffffffffffffff1660008281548110151561045357fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156104c7576000818154811015156104b057fe5b906000526020600020906003020160020154820191505b5b8080600101915050610382565b81600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055505050565b600080600091505b60008054905082101561086b573373ffffffffffffffffffffffffffffffffffffffff1660008381548110151561055857fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614801561061857508373ffffffffffffffffffffffffffffffffffffffff166000838154811015156105ce57fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b1561085e5760008360008481548110151561062f57fe5b90600052602060002090600302016002015403111561067b578260008381548110151561065857fe5b90600052602060002090600302016002016000828254039250508190555061086b565b60008360008481548110151561068d57fe5b906000526020600020906003020160020154031415610858578190505b600160008054905003811015610853576000600182018154811015156106cc57fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660008281548110151561070d57fe5b906000526020600020906003020160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060006001820181548110151561076e57fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000828154811015156107af57fe5b906000526020600020906003020160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060006001820181548110151561081057fe5b90600052602060002090600302016002015460008281548110151561083157fe5b90600052602060002090600302016002018190555080806001019150506106aa565b61085d565b61086c565b5b8180600101925050610525565b5b50505050565b60018181548110151561088157fe5b9060005260206000209060020201600091509050806000018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561092d5780601f106109025761010080835404028352916020019161092d565b820191906000526020600020905b81548152906001019060200180831161091057829003601f168201915b5050505050908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905082565b600080600080600061096d610ebd565b339550869450600093505b600080549050841015610d06578573ffffffffffffffffffffffffffffffffffffffff166000858154811015156109ab57fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610cf957600084815481101515610a0857fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169250600091505b600080549050821015610cf8578273ffffffffffffffffffffffffffffffffffffffff16600083815481101515610a7457fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148015610b3457508473ffffffffffffffffffffffffffffffffffffffff16600083815481101515610aea57fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b15610ceb57600082815481101515610b4857fe5b906000526020600020906003020160020154600085815481101515610b6957fe5b90600052602060002090600302016002016000828254039250508190555085816000019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff168152505084816020019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050600082815481101515610c0657fe5b9060005260206000209060030201600201548160400181815250506000819080600181540180825580915050906001820390600052602060002090600302016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550604082015181600201555050505b8180600101925050610a41565b5b8380600101945050610978565b50505050505050565b610d17610ebd565b8115610d7357610d25610376565b6000600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020541015610d7257610eb7565b5b33816000019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff168152505083816020019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050828160400181815250506000819080600181540180825580915050906001820390600052602060002090600302016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550604082015181600201555050505b50505050565b606060405190810160405280600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff1681526020016000815250905600a165627a7a72305820bb098d264d4512018d26baad8e5cddb967abaaeda7cc717e9342f546d5428bc70029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"receipts\",\"outputs\":[{\"name\":\"come\",\"type\":\"address\"},{\"name\":\"to\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"GetDebt\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"receive\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"PayDebt\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"companies\",\"outputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"adr\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"adr\",\"type\":\"address\"}],\"name\":\"Transfer\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"receive\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"},{\"name\":\"is_bank\",\"type\":\"bool\"}],\"name\":\"Transaction\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final String FUNC_RECEIPTS = "receipts";

    public static final String FUNC_GETDEBT = "GetDebt";

    public static final String FUNC_PAYDEBT = "PayDebt";

    public static final String FUNC_COMPANIES = "companies";

    public static final String FUNC_TRANSFER = "Transfer";

    public static final String FUNC_TRANSACTION = "Transaction";

    @Deprecated
    protected SupplyChain3(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SupplyChain3(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SupplyChain3(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SupplyChain3(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Tuple3<String, String, BigInteger>> receipts(BigInteger param0) {
        final Function function = new Function(FUNC_RECEIPTS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<String, String, BigInteger>>(
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> GetDebt() {
        final Function function = new Function(
                FUNC_GETDEBT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void GetDebt(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETDEBT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String GetDebtSeq() {
        final Function function = new Function(
                FUNC_GETDEBT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> PayDebt(String receive, BigInteger amount) {
        final Function function = new Function(
                FUNC_PAYDEBT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void PayDebt(String receive, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_PAYDEBT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String PayDebtSeq(String receive, BigInteger amount) {
        final Function function = new Function(
                FUNC_PAYDEBT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple2<String, String>> companies(BigInteger param0) {
        final Function function = new Function(FUNC_COMPANIES, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple2<String, String>>(
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> Transfer(String adr) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void Transfer(String adr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String TransferSeq(String adr) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> Transaction(String receive, BigInteger amount, Boolean is_bank) {
        final Function function = new Function(
                FUNC_TRANSACTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(is_bank)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void Transaction(String receive, BigInteger amount, Boolean is_bank, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_TRANSACTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(is_bank)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String TransactionSeq(String receive, BigInteger amount, Boolean is_bank) {
        final Function function = new Function(
                FUNC_TRANSACTION, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(is_bank)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    @Deprecated
    public static SupplyChain3 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain3(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SupplyChain3 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain3(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SupplyChain3 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SupplyChain3(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SupplyChain3 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SupplyChain3(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SupplyChain3> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain3.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<SupplyChain3> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain3.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain3> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain3.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain3> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain3.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
