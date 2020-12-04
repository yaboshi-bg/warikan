package jp.co.biglobe.warikan.datasource.file;

import jp.co.biglobe.warikan.domain.drinking_party.DrinkingParty;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyId;
import jp.co.biglobe.warikan.domain.drinking_party.DrinkingPartyRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDrinkingPartyRepository implements DrinkingPartyRepository {

    public void store(DrinkingParty drinkingParty) {
        try (OutputStream os1 = new FileOutputStream(dPFilePath(drinkingParty.getDrinkingPartyId())); ObjectOutputStream os2 = new ObjectOutputStream(os1)){
            os2.writeObject(drinkingParty);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DrinkingParty drinkingPartyOf(DrinkingPartyId drinkingPartyId) {
        try (InputStream is1 = new FileInputStream(dPFilePath(drinkingPartyId)); ObjectInputStream is2 = new ObjectInputStream(is1)){
            return (DrinkingParty)is2.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DrinkingPartyId nextIdentity() {
        DrinkingPartyId current = readDPId();
        DrinkingPartyId next = new DrinkingPartyId(current.getDrinkingPartyId() + 1);
        writeDPId(next);
        return next;
    }

    private DrinkingPartyId readDPId() {
        try (InputStream is1 = new FileInputStream(dPIdFilePath()); ObjectInputStream is2 = new ObjectInputStream(is1)){
            return (DrinkingPartyId) is2.readObject();
        } catch (Exception e) {
            return new DrinkingPartyId(0);
        }
    }

    private void writeDPId(DrinkingPartyId drinkingPartyId) {
        try (OutputStream os1 = new FileOutputStream(dPIdFilePath()); ObjectOutputStream os2 = new ObjectOutputStream(os1)){
            os2.writeObject(drinkingPartyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String dPFilePath(DrinkingPartyId drinkingPartyId) {
        return String.join(File.separator, "tmp","data","FileDrinkingPartyRepository", "dp_" +  drinkingPartyId.toString() + ".bin");
    }

    private String dPIdFilePath() {
        return String.join(File.separator, "tmp","data","FileDrinkingPartyRepository", "dpid.bin");
    }

    public void refresh() {
        Path path = Paths.get("tmp","data","FileDrinkingPartyRepository");
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(path, "*.bin") ){
            for(Path deleteFilePath : ds){
                Files.delete(deleteFilePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
